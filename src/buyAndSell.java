import java.util.ArrayList;

public class buyAndSell {


    public static int findMaxStock(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int max = 0;
        int curMax = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i] > curMax) {
                max = Math.max(max, array[i] - curMax);
            }else {
                curMax = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array  = new int[] {5,4,3,2,1};
        System.out.println(findMaxStock(array));
    }
}
