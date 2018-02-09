import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class findDisappearedNumbers {
    // Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
    // some elements appear twice and others appear once.

    // Find all the elements of [1, n] inclusive that do not appear in
    // this array.
    public static ArrayList<Integer> findDisappearedNumbers(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i < array.length; i++) {
            if(!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        ArrayList<Integer> list1  = new ArrayList<>();
        for(int  i = 1; i <= array.length; i++) {
            if(!list.contains(i)) {
                list1.add(i);
            }
        }
        return list1;
    }

    public static ArrayList<Integer> findDisappearNumber(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0 ;i < array.length; i++) {
            if(!hmap.containsKey(array[i])) {
                hmap.put(array[i], i);
            }
        }
        for(int  i = 1; i <= array.length; i++) {
            if(!hmap.containsKey(i)) {
                list.add(i);
                System.out.println(list) ;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1};
        //System.out.println(findDisappearedNumbers(arr));
        System.out.println(findDisappearNumber(arr));
    }
}
