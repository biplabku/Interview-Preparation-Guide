import java.util.ArrayList;

public class productOfArray {

    public static ArrayList<Integer> getProductOfArray(int[] array) {
        int mul = 1;
        for(int i = 0; i < array.length; i++) {
            mul = mul * array[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            list.add(mul/array[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,7,3,4};
        System.out.println(getProductOfArray(array));
    }
}
