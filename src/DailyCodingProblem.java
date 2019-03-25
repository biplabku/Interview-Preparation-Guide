import java.util.Arrays;
import java.util.HashSet;

public class DailyCodingProblem {

    public int numberOfArithematicSlices(int[] array) {
        int res = 0;
        for(int i = 0; i < array.length - 2; i++) {
            int diff = array[i + 1] - array[i];
            for(int j = i + 2; j < array.length - 2; j++) {
                if(array[j] - array[j - 1] == diff) {
                    res++;
                }else {
                    break;
                }

            }
        }
        return res;
    }



    public boolean problem1(int[] array, int target) {
        HashSet<Integer> hset  = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if(!hset.contains(diff)) {
                hset.add(array[i]);
            }else {
                return true;
            }
        }
        return false;
    }


    public boolean problem1Method2(int[] array, int k) {
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            int target = k - array[i];
            int j = binarySearch(array, target, 0, array.length, i);
            if(j != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] array, int target, int start, int end, int index) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(array[mid] == target && mid != index) {
                return mid;
            }else if(array[mid] > target) {
                start = mid + 1;
                binarySearch(array, target, start, end, index);
            }else if(array[mid] < target) {
                end = mid - 1;
                binarySearch(array, target, start, end, index);
            }
        }
        return -1;
    }

    int[] newArray;
    // this is still O(N2) implementation
    public void multiplyEach(int[] array) {
        newArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            doMultiply(array, i - 1, i + 1, i);
        }
        for(int i = 0; i < array.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public void doMultiply(int[] array, int left, int right, int index) {
        int leftMul = 1;
        int rightMul = 1;
        while(left >= 0) {
            leftMul = leftMul * array[left];
            left--;
        }

        while(right < array.length) {
            rightMul = rightMul * array[right];
            right++;
        }
        newArray[index] = leftMul * rightMul;
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int temp = 1;
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                result[i] = 1;
            }else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        for(int i = size - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * nums[i];
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public int maxProductSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++) {
            int sum = 1;
            for(int j = i; j < nums.length; j++) {
                sum = sum * nums[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }








    public int maxProductMethod2(int[] nums) {
        int maxProduct2 = nums[0] * nums[1];
        int maxProduct3 = maxProduct2 * nums[2];
        for(int i = 3; i < nums.length; i++) {
            maxProduct2 = Math.max(maxProduct2, nums[i] * nums[i - 1]);
            maxProduct3 = Math.max(maxProduct3, maxProduct2 * nums[i] );
        }
        return maxProduct2;
    }

    public static void main(String[] args) {
        DailyCodingProblem ds = new DailyCodingProblem();
        int[] array = {2,3,-2,4};
        System.out.println(ds.maxProductSubarray(array));
    }
}
