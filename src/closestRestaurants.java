import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class closestRestaurants {


    public List<Integer> ClosesNeighbors(List<List<Integer>> list, int K) {
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            System.out.println(temp.get(0) + " " + temp.get(1));

            int dist = calcDistance(temp.get(0), temp.get(1)) ;
            array[i] = dist;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0; i < K; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public int calcDistance(int x, int y) {
        return (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        List<Integer> temp1 = new ArrayList<>();

        temp1.add(2);
        temp1.add(4);

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(0);
        temp2.add(1);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(3);
        temp3.add(4);

        List<Integer> temp4 = new ArrayList<>();
        temp4.add(5);
        temp4.add(6);

        list.add(temp);
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);
        closestRestaurants ms = new closestRestaurants();
        System.out.println(ms.ClosesNeighbors(list, 4));
    }
}
