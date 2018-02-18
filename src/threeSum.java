import java.util.ArrayList;
import java.util.Arrays;

public class threeSum {


    public static ArrayList<ArrayList<Integer>> threeSum(int[] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(array);

        for(int i = 0 ; i < array.length -2; i++) {
            if(i==0 || array[i] != array[i-1]){
                int first = i + 1;
                int last = array.length - 1;
                while(first < last) {
                    if (array[i] + array[first] + array[last] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(array[i]);
                        list.add(array[first]);
                        list.add(array[last]);
                        result.add(list);
                        first++;
                        last--;
                        while (first < last && array[first] == array[first - 1]) {
                            first++;
                        }
                        while (first < last && array[last] == array[last + 1]) {
                            last--;
                        }
                    } else if (array[i] + array[first] + array[last] < 0) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(array));

    }
}
