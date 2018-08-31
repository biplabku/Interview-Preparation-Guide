import java.util.ArrayList;

public class nextPermutation {


    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i + 1) <= list.get(i)) {
            i--;
        }
        if (i >= 0) {
            int j = list.size() - 1;
            while (j >= 0 && list.get(j) <= list.get(i) ){
                j--;
            }
            swap(list, i, j);
        }
        reverse(list, i + 1);
        return list;
    }

    private static void reverse(ArrayList<Integer> list, int start) {
        int i = start, j = list.size() - 1;
        while (i < j) {
            swap(list, i, j);
            i++;
            j--;
        }
    }

    public static void swap(ArrayList<Integer> list, int i, int j ) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);;
        list.add(3);
        list.add(1);
        System.out.println(nextPermutation(list));
    }
}
