import java.util.Arrays;
import java.util.HashSet;

public class DailyCodingProblem {

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

    public static void main(String[] args) {
        DailyCodingProblem ds = new DailyCodingProblem();
        int[] array = {10, 15, 3, 7};
        System.out.println(ds.problem1Method2(array, 17));
    }
}
