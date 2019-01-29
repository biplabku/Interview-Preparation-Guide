public class nthMinElement {


    public int minElemeny(int[] array) {
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


    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        nthMinElement ms = new nthMinElement();
        int[] array = {2,3,4,5,6, 0,1};
        System.out.println(ms.secondMinElement(array));
    }
}
