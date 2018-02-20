import java.util.ArrayList;

public class evenOdd {


    public static void setTheElements(int[] array) {
        int nextEven = 0;
        int nextOdd = array.length - 1;
        while(nextEven < nextOdd) {
            if(array[nextEven] %2 == 0 ) {
                nextEven++ ;
            }else {
                int temp = array[nextEven];
                array[nextEven] = array[nextOdd];
                array[nextOdd] = temp;
                nextOdd--;
            }
        }
        System.out.println(array);
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7};
        setTheElements(array);
    }
}
