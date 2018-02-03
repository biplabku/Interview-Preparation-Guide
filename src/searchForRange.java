import java.util.ArrayList;
import java.util.HashMap;

public class searchForRange {


    public static ArrayList<Integer> searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 1;
        int high = nums.length;
        while(low <= high) {
            int mid = low + (high - low) /2;
            if(nums[mid] == target) {
                list.add(low, high);
                return list;
            }else if(nums[mid] < target) {
                high = mid +1;
            }else {
                low = mid - 1;
            }
        }
        list.add(-1);
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
       int[] array = new int[] {5, 7, 7, 8, 8, 10} ;
       int target = 8;

       System.out.println(searchRange(array, target));
    }
}
