import java.util.ArrayList;

public class nonNegMaxSum {

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int index = 0;
        int sum = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < 0) {
                index = i;
                continue;
            }

        }
        for(int i = 0; i < index; i++) {
            sum += A.get(i);
        }
        int sum2 = 0;
        for(int i = index + 1; i < A.size(); i++) {
            sum2 += A.get(i);
        }

        if(sum > sum2) {
            return new ArrayList<>(A.subList(0, index ));
        }else if(sum == sum2) {
            return A.subList(0, index).size() > A.subList(index + 1, A.size()).size() ?
                    new ArrayList<>(A.subList(0, index)) : new ArrayList<>(A.subList(index + 1, A.size()));
        }else {
            return new ArrayList<>(A.subList(index + 1, A.size()));
        }
    }

    public static void main(String[] args) {
        nonNegMaxSum ms = new nonNegMaxSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(-7);
        list.add(2);
        list.add(6);
        System.out.println(ms.maxset(list));
    }
}
