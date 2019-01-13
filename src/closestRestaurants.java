import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class closestRestaurants {


    public List<Integer> ClosesNeighbors(List<List<Integer>> list, int N, int K) {
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
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

    }
}
