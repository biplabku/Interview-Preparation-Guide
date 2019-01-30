import java.util.Arrays;

public class nthMinElement {


    public int minElement(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    public int secondMinElement(int[] array) {
        int min = array[0];
        int secondMin = array[1];
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                secondMin = min;
                min = array[i];
            }else if(array[i] < secondMin) {
                secondMin = array[i];
            }
        }
        return secondMin;
    }

    public int nthMinElement(int[] array, int n) {
        int start = 0;
        int end = array.length - 2;
        int[] newArray = new int[array.length ];
        int index = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[index]) {
                newArray[start] = array[i];
                start++;
            }else {
                newArray[end] = array[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(newArray));
        if(n > start) {
            return nthMinElement(Arrays.copyOfRange(newArray, start + 1 , newArray.length),
                    n -  start);
        }else if(n < start) {
            return nthMinElement(Arrays.copyOfRange(newArray, 0, start), n);
        }else{
            return array[start];
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        nthMinElement ms = new nthMinElement();
        int[] array = {5,6,3,15,11};
        System.out.println(ms.nthMinElement(array, 2));
    }
}
