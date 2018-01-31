import java.util.ArrayList;
import java.util.HashMap;

public class twoSum {

    public static ArrayList<Integer> twoSum(int[] numbers, int target) {
        ArrayList<Integer> ar = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if(!hmap.containsKey(target - numbers[i])) {
                hmap.put(numbers[i], i);
            }else {
                ar.add(hmap.get(target - numbers[i]));
                ar.add(i);
                return ar;
            }
        }
        System.out.println("fsadad");
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSum(numbers, target));
    }
}
