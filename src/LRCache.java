import java.util.*;

public class LRCache {

    class Node {
        Node next;
        Node prev;
        int key;
        int value;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> hmap = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    int count ;
    public LRCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node node = hmap.get(key);
        if(node == null) {
            node = new Node(key, value);
            hmap.put(key, node);
            addNode(node);
            ++count;
            if(count > capacity) {
                tail = popTail();
                hmap.remove(tail.key);
                --count;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int key) {
        Node node = hmap.get(key);
        if(node == null) {
            return  -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public void removeNode(Node node) {
        Node pre = node.prev;
        Node nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }

    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }
    private Node popTail(){
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseKGroups(ListNode head, int k) {
        ListNode cur = head;
        ListNode newHead = null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int counter = 0;
        while(cur != null) {
            ++counter;
            if(counter % k == 0) {
                prev = revese(k, prev, cur.next);
            }
        }
        return newHead;
    }

    public ListNode revese(int k, ListNode prev, ListNode end) {
        ListNode head = prev;
        ListNode cur = head.next;
        ListNode nxt = null;
        while(cur != end) {
            ListNode temp = cur.next;
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            k--;
        }
        if(k > 0) {
            return null;
        }
        return prev;
    }


    public int[] prodOfSelf(int[] array) {
        int[] newArray = new int[array.length];
        newArray[0]  = array[0];
        for(int i = 1; i < array.length; i++) {
            newArray[i] = array[i - 1] * newArray[i - 1];
        }
        int num = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            newArray[i] = num * newArray[i];
            num = num * array[i];
        }
        return newArray;
    }

    public List<Integer> locateSmallest(int[] array) {
        int left = 0;
        int right = 0;
        boolean isSeen = false;
        for(int i = 0; i < array.length; i++) {
            if((i + 1) < array.length && array[i] > array[i + 1] && isSeen == false) {
                left = i;
                isSeen = true;
            }
            if(isSeen == true && array[left] - array[i] < 0) {
                right = i - 1;
                break;
            }
        }
        List<Integer> list= new ArrayList<>();
        list.add(left);
        list.add(right);
        return list;

    }

    public int maxSubArraySum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            int val = array[i];
            for(int j = i + 1; j < array.length; j++) {
                val += array[j];
                if(val > sum) {
                    sum = val;
                }
            }
        }
        return sum;
    }
    // what if you need to find the arraylist from the array instead of getting the sum
    public int maxSubArraySumImprove(int[] array) {
        int currentMax = 0;
        int maxFinal = 0;
        // computer both maximums o, one including the current max and the other not including the current max
        for(int i = 0; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxFinal = Math.max(currentMax, maxFinal);
        }
        return maxFinal;
    }

    // 34, -50, 42, 14, -5, 86
    public List<Integer> getMaxSubarray(int[] array) {
        int leftIndex = 0;
        int rightIndex = 0;
        int currentMax = 0;
        int finalMax = 0;
        for(int i = 0; i < array.length; i++) {
            currentMax = currentMax + array[i];
            if(finalMax < currentMax) {
                finalMax = currentMax;
                rightIndex = i;
            }
            if(currentMax < 0) {
                currentMax = 0;
                leftIndex = i + 1;
            }
        }
        List<Integer> list = Arrays.asList(leftIndex, rightIndex);
        return list;
    }

    public boolean searchTarget(int[][] array, int target) {
        if(array == null || array.length == 0 || array[0].length == 0 || array[0] == null) {
            return false;
        }
        int row = 0;
        int col = 0;
        boolean seen = false;
        if(array.length == 1) {
            int[] ar = new int[array[0].length];
            for(int i = 0; i <  array[0].length; i++) {
                ar[i] = array[0][i];
            }
            return binarySearch(ar, 0,array.length, target);
        }
        if(array[0].length == 1) {
            int[] ar = new int[array.length];
            for(int i = 0; i <  array.length; i++) {
                ar[i] = array[i][0];
            }
            return binarySearch(ar, 0,array.length, target);
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {

            }
        }
        int[] rowArray = new int[row + 1];
        int[] colArray = new int[col + 1];

        for(int i = 0; i <=  col; i++) {
            rowArray[i] = array[row][i];
        }

        for(int i = 0; i <= row; i++) {
            colArray[i] = array[i][col];
        }
        return binarySearch(rowArray, 0, row, target) == true || binarySearch(colArray, 0, col, target) == true;
    }

    public boolean binarySearch(int[] array, int start, int end, int target) {
        if(array.length == 1) {
            return target == array[0];
        }
        while(start <= end) {
            int mid = (start + end )/2;
            if(array[mid] == target) {
                return true;
            }
            if(target > array[mid]) {
                start = mid + 1;
            }else if(target < array[mid]) {
                end = mid -1;
            }
        }
        return false;
    }


    public int[] dailyTemperatures(int[] temperature) {
        int[] result = new int[temperature.length];
        for(int i = 0; i < temperature.length; i++) {
            for(int j = i + 1; j < temperature.length; j++) {
                if(temperature[j] > temperature[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTempCal(int[] temperature) {
        int[] result = new int[temperature.length];
        countLoop:
        for(int i = temperature.length - 2; i >= 0; i--) {
            int j = i + 1;
            while(j < temperature.length) {
                if(temperature[i] < temperature[j]) {
                    result[i] = j - i;
                    continue countLoop;
                }else if(result[j] == 0) {
                    continue countLoop;
                }else {
                    j = j + result[j];
                }
            }
        }
        return result;
    }

    public int[][] reconstructionQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < people.length; i++) {
            int x = people[i][0];
            int y = people[i][1];
            for(int j = 0; j < people.length; j++) {
                if(i != j) {
                    int x1 = people[j][0];
                    int y1 = people[j][1];
                    if(y == y1) {
                        x = Math.min(x, x1);
                    }else {
                        // check if there is anything that is greater
                    }
                }
            }
            result[i][0] = x;
            result[i][1] = y;
        }
        return result;
    }


    public String removeDuplicates(String str) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch) + 1);
            }else {
                hmap.put(ch, 1);
            }
        }

        return str;
    }

    public List<String> generateParanthesis(int number) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number; i++) {
            sb.append('(');
        }
        for(int j = 0; j < number; j++) {
            sb.append(')');
        }
        char[] ar = sb.toString().toCharArray();
        List<String> permutations= new ArrayList<>();
        generateParanthesis(ar, 0, permutations);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < permutations.size(); i++) {
            String str = permutations.get(i);
            if(checkParanth(str) && !res.contains(str)) {
                res.add(str);
            }
        }

        return res;
    }

    public boolean checkParanth(String str) {
        Stack<Character> theStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                if(theStack.isEmpty()) {
                    return false;
                }else {
                    theStack.pop();
                }
            }else if(ch == '(') {
                theStack.push('(');
            }
        }
        return theStack.isEmpty();
    }

    public void generateParanthesis(char[] str, int start, List<String> permutations) {
        if(start == str.length - 1) {
            StringBuilder sb = new StringBuilder();
            for(char ch : str) {
                sb.append(ch);
            }
            permutations.add(sb.toString());
            return;
        }
        for(int i = start; i < str.length; i++) {
            swap(str, i, start);
            generateParanthesis(str, start + 1, permutations);
            swap(str, i, start);
        }
    }

    public void swap(char[] ar, int i, int j) {
        char tem= ar[i];
        ar[i] = ar[j];
        ar[j] = tem;
    }

    public List<String> generateOpenCloseParanthesis(int number) {
        List<String> output = new ArrayList<>();
        construct("", output, number, number);
        return output;
    }

    public void construct(String cur, List<String> output, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            output.add(cur);
            return;
        }
        if(left > 0) {
            construct(cur + "(", output, left - 1, right);
        }
        if(right > 0) {
            construct(cur + ")", output, left, right - 1);
        }
    }

    // 1,2,1,3,2,5
    // missing number - 3,5
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            }else {
                hmap.remove(nums[i]);
            }
        }
        Iterator iter = hmap.entrySet().iterator();
        int[] res = new int[hmap.size()];
        int count = 0;
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            res[count++] = (int)pair.getKey();
        }
        return res;
    }

    public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i =0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            }else {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }
            if(hmap.get(nums[i]) == 3) {
                hmap.remove(nums[i]);
            }
        }
        return 1;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry =0;
        while(len1 >= 0 && len2 >= 0) {
            int d1 = Character.getNumericValue(num1.charAt(len1));
            int d2 = Character.getNumericValue(num2.charAt(len2));
            int tot = d1 + d2 + carry;
            if(tot > 9) {
                carry = tot/10;
                tot = tot%10;
            }else {
                carry = 0;
            }
            sb.append(tot);
            len1--;
            len2--;
        }
        while(len1 >= 0) {
            int d1 = Character.getNumericValue(num1.charAt(len1));
            int tot = carry + d1;
            if(tot > 9) {
                carry = tot/10;
                tot = tot%10;
            }else{
                carry = 0;
            }
            sb.append(tot);
            len1--;
        }
        while(len2 >= 0) {
            int d1 = Character.getNumericValue(num2.charAt(len2));
            int tot = carry + d1;
            if(tot > 9) {
                carry = tot/10;
                tot = tot%10;
            }else {
                carry = 0;
            }
            sb.append(tot);
            len2--;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public boolean isPowerOfThree(int n) {
        int count = 3;
        while(count > 0) {
            if(n % 3 != 0) {
                break;
            }
            n = n / 3;
            count--;
        }
        return count == 0 ? true:false;
    }

    int paths = 0;
    public int uniquePaths(int[][] grid) {
        int zeroCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    zeroCount += 1;
                }
            }
        }
        return paths;
    }

    public void DFSearch(int[][] grid, int zeroCount, int r, int c) {
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length) {
            return;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> hset = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if(!hset.containsKey(val)){
                hset.put(nums[i], i);
            }else {
                arr[0] = hset.get(val);
                arr[1] = i;
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        LRCache ls = new LRCache(2);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        int[] arr = {2,2,3,2};
        int[][] array = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(ls.isPowerOfThree(8));


    }
}
