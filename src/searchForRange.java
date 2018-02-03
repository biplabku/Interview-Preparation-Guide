import java.util.ArrayList;
import java.util.HashMap;

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

    public static ArrayList<Integer> searchRangeMethod3(int[] array, int target) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(-1);
        list.add(-1);
        int low = getFirstMatch(array, target);
    }


    public static void main(String[] args) {
       int[] array = new int[] {5, 7, 7, 8, 8, 10} ;
       int target = 8;

       System.out.println(searhRangeMethod2(array, target));
    }
}
