import java.util.ArrayList;
import java.util.List;

public class searchForRange {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        int index1 = 0;
        getSum(nums, target,0, new ArrayList<>(), result, 0);
        return result;
    }

    public static void getSum(int[] nums, int target, int index, List<Integer> list, List<List<Integer>> result, int sum) {
         if(sum == target) {
             result.add(new ArrayList<>(list));
             return;
         }

         if(index >= nums.length || sum > target) {
             return;
         }

         sum += nums[index];
         list.add(nums[index]);
         getSum(nums, target, index, list, result, sum);

         // if summing up makes it greater than target, remove the last value that is added as well as remove it from the sum
         sum -= nums[index];
         list.remove(list.size() - 1);
         getSum(nums, target, index + 1, list, result, sum);

    }

    public static ArrayList<Integer> searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();

        int low = 1;
        int high = nums.length;
        while(low <= high) {
            int mid = (low + (high - low)) /2;
            if(nums[mid] == target) {
                list.add(low);
                list.add( high);
                return list;
            }else if(nums[mid] < target) {
                low = mid +1;
            }else {
                high = mid - 1;
            }
        }
        list.add(-1);
        list.add(-1);
        return list;
    }

    public static ArrayList<Integer> searhRangeMethod2(int[] array, int target) {
        int low = -1;
        int high = -1;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                low = i;
                break;
            }
        }

        for(int  i = array.length - 1; i >= 0; i--) {
            if(array[i] == target) {
                high = i;
                break;
            }
        }

        ArrayList<Integer> list= new ArrayList<>();
        list.add(low);
        list.add(high);
        return list;
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] > target || (left && target == nums[mid])) { // selecting the left side when there is a match
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static ArrayList<Integer> searchRangeMethod3(int[] nums, int target) {
        ArrayList<Integer> targetRange  = new ArrayList<>();
        targetRange.add(-1);
        targetRange.add(-1);

        int leftIdx = extremeInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        targetRange.clear();
        targetRange.add(leftIdx);
        targetRange.add(extremeInsertionIndex(nums, target, false)-1);

        return targetRange;
    }

    public static void main(String[] args) {
       int[] array = new int[] {2,3,6,7} ;
       int target = 8;

       System.out.println(combinationSum(array, target));
    }
}
