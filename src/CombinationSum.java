import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // 2,3,6,7
    // 8
    // [2,2,2,2], [2,2,3], [2,6] = 8,
    // 2,2,2,2  == sum = 8, sum -
    // sum = 2, index = 0
    // sum =4, index = 0
    // sum =6, index = 0
    // sum = 8, index= 0;
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        GetSum(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    public static void GetSum(int[] nums, int target, int sum, int index, List<Integer> list) {
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(index > nums.length || sum > target) {
            return ;
        }

        sum += nums[index];
        list.add(nums[index]);
        GetSum(nums, target, sum, index, list);

        sum -= nums[index];
        list.remove(list.size() - 1);
        GetSum(nums, target, sum, index + 1, list);
    }

    public static int addNumbers(int a, int b) {
        // here both a and be are integers. and only positive integer.
        // Working on a temp methood.
        return a+b;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,3,5} ;
        int target = 8;

        System.out.println(combinationSum(array, target));
    }
}
