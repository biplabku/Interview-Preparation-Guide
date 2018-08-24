import java.util.ArrayList;

public class maxAbsoluteDiff {

    public int maxAbsDiff(ArrayList<Integer> list) {
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                max = Math.max(max, (Math.abs(list.get(i) - list.get(j)) + Math.abs(i - j)));
            }
        }
        return max;
    }

    // how can you implement in O(N)

    public int maxAbsDiff1(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        // save the largest and smallest values with its index
        for(int i = 0; i < list.size(); i++) {
            if(max < list.get(i)) {
                max = list.get(i);
                maxIndex = i;
            }
        }
        for(int i = 0; i < list.size(); i++) {
            if(min > list.get(i)) {
                min = list.get(i);
                minIndex = i;
            }
        }
        System.out.println(max + " " + min + " " + maxIndex + " " + minIndex);
        return Math.abs(list.get(maxIndex) - (list.get(minIndex))) + Math.abs(minIndex - maxIndex);
    }

    public int maxAbsDiff2(ArrayList<Integer> list) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int sum = 0;
        // save the largest and smallest values with its index
        for(int i = 0; i < list.size(); i++) {
            max1 = Math.max(max1, (list.get(i) + i));
            max2 = Math.max(max2, (list.get(i) - i));
            min1 = Math.min(min1, (list.get(i) + i));
            min2 = Math.min(min2, (list.get(i) - i));
        }
        sum = Math.max(max1 - min1, max2 - min2);
        return sum;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        maxAbsoluteDiff ms = new maxAbsoluteDiff();
        list.add(55);
        list.add(-8);
        list.add(43);
        list.add(52);
        list.add(8);
        list.add(59);
        list.add(-91);
        list.add(-79);
        list.add(-18);
        list.add(-94);
        System.out.println(ms.maxAbsDiff2(list));
    }
}
