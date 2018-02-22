import java.util.ArrayList;

public class productOfArray {

    public static ArrayList<Integer> getProductOfArray(int[] array) {
        int mul = 1;
        for(int i = 0; i < array.length; i++) { // O(N) // O(1)
            if(array[i] == 0 ) {
                mul = mul * 1;
            }else {
                mul = mul * array[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {  // O(N) // O(N)
            if(array[i] == 0) {
                list.add(mul/1);
            }else{
                list.add(mul/array[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,7,0,4};
        System.out.println(getProductOfArray(array));
    }
}
