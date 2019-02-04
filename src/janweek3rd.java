import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length ; i++) {
            int sum = array[i];
            for(int j = i + 1; j < array.length; j++) {

                if(array[i] < ) {
                    break;
                }else {
                    sum = sum * (j - j + 1);
                }
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


























    public static void main(String[] args) {
        janweek3rd js = new janweek3rd();
        int[] array = {1,6,5,2,5};
        int k = 13;
        System.out.println(js.getMaxWaterContainer(array));
    }
}
