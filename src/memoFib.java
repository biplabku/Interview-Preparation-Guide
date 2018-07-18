import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class memoFib {

    public static HashMap<Integer, Integer> hmap = new HashMap<>();

    public int checkSortedArray(int[] array, int number) {
        if(number == 1 ) {
            return 1;
        }
        return (array[number - 1] < array[number - 2] ? 0:checkSortedArray(array, number - 1));
    }

    public int fib(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }

        if(hmap.containsKey(number)) {
            return hmap.get(number);
        }

        int result = fib(number - 1) + fib(number - 2);
        hmap.put(number, result);
        return fib(result);
    }

    // bottom up approach for dynamic programming
    public  int multiple(int number) {
        int result = 1;
        for(int i = 1; i < number; i++) {
            result *= i;
        }
        return result;
    }

    // permutations of the string
    public HashSet<String> permutationString(String str) {
        HashSet<String> hset = new HashSet<>();
        if(str.length() <= 1) {
            return new HashSet<>(Collections.singletonList(str));
        }
        return hset;
    }



    public static void main(String[] args) {
        memoFib ms = new memoFib();
        System.out.println(ms.fib(1));
        System.out.println(ms.multiple(4));
    }
}
