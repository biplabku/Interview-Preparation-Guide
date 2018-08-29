import java.util.ArrayList;

public class nextPermutation {


    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> list) {
        for(int i = list.size() - 1; i > 0; i--) {
            if(list.get(i) > list.get(i - 1)) {
                int temp = list.get(i - 1);
                list.set(i - 1, list.get(i));
                list.set(i, temp);
                return list;
            }
        }
        // return the smallest if the highest does not occur
        int len = list.size() - 1;
        for(int i = 0; i < list.size()/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(len - i));
            list.set(len - i, temp);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);;
        list.add(3);
        list.add(1);
        System.out.println(nextPermutation(list));
    }
}
