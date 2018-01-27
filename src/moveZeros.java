import java.util.LinkedList;

public class moveZeros {

    public static LinkedList<Integer> moveZeros(int[] array) {
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

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] array = new int[] {1,2,3,4,};
        System.out.println(moveZeros(array));
    }
}
