import java.util.ArrayList;
import java.util.Arrays;

public class findDisappearedNumbers {
    // Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
    // some elements appear twice and others appear once.

    // Find all the elements of [1, n] inclusive that do not appear in
    // this array.
    public static ArrayList<Integer> findDisappearedNumbers(int[] array) {
        //
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        int n = array.length;
        for(int  i = 0; i < array.length; i++) {
            if(array[i] < n && !list.contains(array[i])) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}
