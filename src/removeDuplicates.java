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

    public static ArrayList<Integer> removeDuplicates2(ArrayList<Integer> nums) {
        HashSet<Integer> hset = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int j = 0; j < nums.size(); j++) {
            if(!hset.contains(nums.get(j))) {
                hset.add(nums.get(j));
                list.add(nums.get(j));

            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,1,2,2,8,6,3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(8);
        list.add(6);
        list.add(3);
        // System.out.println(removeDuplicates(array));
        System.out.println(removeDuplicates2(list));
    }
}
