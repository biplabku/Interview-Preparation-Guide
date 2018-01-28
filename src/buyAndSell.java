import java.util.ArrayList;

public class buyAndSell {


    public static int findMaxStock(int[] array) {
        ArrayList<Integer> list= new ArrayList<>();
        int min = array[0];
        int ptr1 = 0;
        int ptr2 = 1;
        int max = array[1];
        int diff = 0;
        for(int i = 0;i < array.length-1; i++) {
            if(min > array[i]) {
                ptr1  = i;
                min = Math.min(min, array[i]);
            }
            if(max < array[i + 1]) {
                ptr2 = i + 1;
                max = Math.max(max, array[i + 1]);
            }
            diff = Math.max((max - min), diff);
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] array  = new int[] {7, 5, 4, 3, 2, 1};
        System.out.println(findMaxStock(array));
    }
}
