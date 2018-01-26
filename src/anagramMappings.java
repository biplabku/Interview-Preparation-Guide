import java.util.ArrayList;
import java.util.HashMap;

public class anagramMappings {


    public static ArrayList<Integer> findAnagramMapping(int[] A, int[] B) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            hmap.put(B[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < B.length; i++) {
            list.add(hmap.get(A[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = new int[] {12,28,46,32,50};
        int[] B = new int[] {50,12,32,46,28};
        System.out.println(findAnagramMapping(A, B)) ;
    }
}
