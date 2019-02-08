import java.util.*;

public class janweek3rd {


    public List<Integer> add2Numbers(int[] array, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length -1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == k) {
                    list.add(array[i]);
                    list.add(array[j]);
                    break;
                }
            }
        }
        return list;
    }
    // 10, 15, 3, 7     k = 17
    public List<Integer> add2NumbersFast(int[] array, int k) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int val = Math.abs(k - array[i]);
            if(hset.contains(val)) {
                list.add(val);
                list.add(array[i]);
                break;
            }else {
                hset.add(array[i]);
            }
        }
        return list;
    }


    // Input: S = "loveleetcode", C = 'e'
    // Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

    public int[] shortestToChar(String str, char ch) {
        int[] array = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            int res = getClosestValue(str, i, ch);
            array[i] = res;
        }
        display(array);
        return array;
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public int getClosestValue(String str, int index, char ch) {
        int leftIndex = index;
        int rightIndex = index;
        int left = 0;
        int right = 0;
        while(leftIndex >= 0) {
            if(str.charAt(leftIndex) == ch) {
                break;
            }
            leftIndex--;
            left++;
        }
        if(leftIndex < 0) {
            left = Integer.MAX_VALUE;
        }
        while(rightIndex < str.length()) {
            if(str.charAt(rightIndex) == ch) {
                break;
            }
            rightIndex++;
            right++;
        }
        if(rightIndex >= str.length()) {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right);
    }

    // 1, 3, 2, 2, 3, 1
    // 1, 1, 2, 2, 3, 3

    // odd -- 1, 2, 3
    // even - 1, 2, 3
    //
    public int[] wiggleSort(int[] array) {
        Arrays.sort(array);
        // find the median element
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
            }
        }
        return array;
    }



    public ArrayList<Integer> flip(String str) {
        return new ArrayList<>();
    }

    public void selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for(int j = i + 1; j < array.length; j++) {
                if(min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        display(array);
    }

    public void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int j = i - 1;
            int val = array[i];
            while(j >= 0 && array[j] > val)  {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = val;
        }
        display(array);
    }

    public List<Integer> isSelfDividingNumber(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    // create a helper function to check whether the number is self dividing number or not
    // 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

    public boolean isSelfNumber(int number) {
        int original = number;
        while(number > 1) {
            int remainder = number % 10;
            number = number/10;
            if(remainder == 0 || original % remainder != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isPerfectNumber(int number) {
        if(number == 0) {
            return false;
        }
        int result = 0;
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                result += i;
            }
        }
        return result == number;
    }


    public int getMaxWaterContainer(int[] array) {
        int max = 0;
        for(int i = 0; i < array.length ; i++) {
            for(int j = i + 1; j < array.length; j++) {
                max = Math.max(max, Math.min(array[i], array[j]) * (j - i));
            }
        }
        return max;
    }


    public int getMaxSecondMethod(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int max = 0;
        while(left < right) {
            max = Math.max(max, Math.min(array[left], array[right]) * (right - left));
            if(array[left] < array[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }


    public List<List<Integer>> getCombinatorialSum(int k, int number) {
        List<List<Integer>> result = new ArrayList<>();
        getTheSumList(result, k, number, new ArrayList<>(), 1);
        return result;
    }

    public void getTheSumList(List<List<Integer>> list, int k, int number, List<Integer> curentList, int start) {
        // end case
        if(curentList.size() == k && number == 0) {
            int[] arr = new int[curentList.size()];
            for(int i = 0;i < curentList.size(); i++) {
                arr[i] = curentList.get(i);
            }
            Arrays.sort(arr);
            curentList.clear();
            for(int i = 0; i < arr.length; i++) {
                curentList.add(arr[i]);
            }
            if(!list.contains(curentList)) {
                list.add(new ArrayList<>(curentList));

            }
            return ;
        } else {
            for(int i = 1; i < 10; i++) {
                if(curentList.contains(i)) {
                    continue;
                }
                curentList.add(i);
                getTheSumList(list, k, number - i, curentList, i + 1);
                curentList.remove(curentList.size() - 1);
            }
        }
    }

    // total number of binary nodes
    public int totalBinaryNodes(BSTNode node, int res) {
        if(node == null) {
            return 1;
        }
        res = 1 + totalBinaryNodes(node.leftChild, res) + totalBinaryNodes(node.rightChild, res);
        return res;
    }

    // Given the root to a binary tree, return the deepest node.


    public int getMaxHeight(BSTNode node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(getMaxHeight(node.leftChild), getMaxHeight(node.rightChild));
    }


    public int firstMissingPositive(int[] array) {
        if(array.length < 1) {
            return 1;
        }
        if(array.length == 1) {
            if(array[0] > 2) {
                return 1;
            }else if(array[0] == 1) {
                return 2;
            }
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if(!hmap.containsKey(array[i])) {
                hmap.put(array[i], 1);
            }
        }
        int i = 1;
        int count = 0;
        for(i = 1; i <= array.length; i++) {
            if(!hmap.containsKey(i)) {
                return i;
            }else {
                count++;
            }
        }
        if(count == hmap.size()) {
            return i;
        }
        return i+1;

    }


    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Double> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int val = queue.size();
            double sum = 0;
            for(int i = 0; i < val; i++) {
                TreeNode node = queue.poll();
                sum += node.data;
                if(node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if(node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
            result.add(sum/val);
        }
        return result;
    }

    public List<Integer> findDuplicates(int[] array) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[ i + 1]) {
                if(!result.contains(array[i + 1])) {
                    result.add(array[i + 1]);

                }
            }
        }

        return result;
    }

   

    public static void main(String[] args) {
        janweek3rd js = new janweek3rd();
        int[] array = {2,1};
        int k = 13;
        System.out.println(js.firstMissingPositive(array));
    }
}
