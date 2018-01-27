import java.util.LinkedList;

public class moveZeros {

    public static int[] array = new int[] {0,1,0,3,12};

    public static LinkedList<Integer> moveZeros() {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i  = 0; i < array.length; i++) {
            if(array[i] != 0) {
                list.add(array[i]);
            }
        }
        int len = list.size();
        while(len != array.length) {
            list.add(0);
            len++;
        }
        return list;
    }

    // time complexity - O(N). space complexity - O(1). In place
    public static void moveZerosMethod1() {
        int pointer1= 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
               swap(pointer1, i);
               pointer1 = pointer1 + 1;
            }
        }
        display();
    }

    public static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void display() {
        for(int i = 0; i < array.length;i ++) {
            System.out.print(array[i]+ " ");
        }
    }
    public static void main(String[] args) {
        // System.out.println(moveZeros());
        moveZerosMethod1();

    }
}
