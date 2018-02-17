import java.util.ArrayList;
import java.util.HashSet;

public class removeDuplicates {


    public static HashSet<Integer> removeDuplicates(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int j = 0; j < nums.length; j++) {
            if(!hset.contains(nums[j])) {
                hset.add(nums[j]);
            }
        }
        return hset;
    }

    public static HashSet<Integer> removeDuplicates1(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int j = 0; j < nums.length; j++) {
            if(!hset.contains(nums[j])) {
                hset.add(nums[j]);
                list.add(nums[j]);

            }
        }
        return hset;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,1,2,2,8,6,3};
        System.out.println(removeDuplicates(array));
    }
}
