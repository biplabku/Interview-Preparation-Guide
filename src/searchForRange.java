import java.util.ArrayList;

public class searchForRange {


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
       int[] array = new int[] {5, 7, 9, 6, 6, 10} ;
       int target = 7;

       System.out.println(searhRangeMethod2(array, target));
    }
}
