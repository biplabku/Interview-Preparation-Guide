import java.util.HashSet;

public class removeDuplicatesFromArray {

    public void removeDups(int[] array) {
        int index = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i - 1] != array[i]) {
                array[index] = array[i];
                index++;
            }else {
                continue;
            }
        }
        for(int i = 0; i < index; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        removeDuplicatesFromArray rs = new removeDuplicatesFromArray();
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        rs.removeDups(array);
    }
}
