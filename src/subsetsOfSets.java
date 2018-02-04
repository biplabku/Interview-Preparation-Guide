import java.util.ArrayList;
import java.util.Vector;

public class subsetsOfSets {

    public static void subsetOfSets(int[] array) {
        int[] subset = new int[array.length];
        helper(array, subset, 0);
    }

    public static void helper(int[] array, int[] subset, int i) {

        if(i == array.length) {
            System.out.println(subset);
        }else {
            subset = null;
            helper(array, subset, i + 1);
            subset[i] = array[i];
            helper(array, subset, i + 1);
        }
    }


    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            System.out.println(item +  " my name is" + allsubsets);

            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);

        }
        return allsubsets;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        // 0 1 2
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());
    }
}
