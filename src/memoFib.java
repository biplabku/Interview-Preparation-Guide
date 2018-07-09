import java.util.HashMap;

public class memoFib {

    public static HashMap<Integer, Integer> hmap = new HashMap<>();

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

    public static void main(String[] args) {
        memoFib ms = new memoFib();
        System.out.println(ms.fib(3));
    }
}
