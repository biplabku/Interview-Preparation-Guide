import java.util.*;

public class closestRestaurants {


    public List<List<Integer>> ClosesNeighbors(List<List<Integer>> list, int K) {
        int[] array = new int[list.size()];
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            int dist = calcDistance(temp.get(0), temp.get(1)) ;
            hmap.put(dist, temp);
        }

        Map<Integer, List<Integer>> sortMap = new TreeMap<>(hmap);
        Set set2 = sortMap.entrySet();
        Iterator iter = set2.iterator();
        List<List<Integer>> result = new ArrayList<>();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            List<Integer> temp = (List<Integer>)pair.getValue();
            result.add(temp);
        }
        return result;
    }

    public int calcDistance(int x, int y) {
        return (int)Math.sqrt((0 - x) * (0 - x) + (0 - y) * (0 - y));
    }

    public int mexHeightStack(int[] array1, int[] array2, int[] array3) {
        cumulativeSum(array1);
        cumulativeSum(array2);
        cumulativeSum(array3);
        int index1 = array2.length - 1;
        int index2 = array3.length - 1;
        int max = 0;
        for(int i = array1.length - 1; i >= 0; i--) {
            int el = array1[i];
            while(el != array2[index1] && index1 > 0) {
                index1--;
            }
            while(el != array3[index2] && index2 > 0) {
                index2--;
            }
            if(index1 < 0 && index2 < 0 || index1 == 0 && index2 >= 0 ) {
                index1  = array2.length - 1;
                index2 = array3.length - 1;
                continue;
            }else if(index1 >= 0 && index2 >= 0) {
                max = el;
            }
        }
        return max;
    }

    public void cumulativeSum(int[] array) {
        for(int i =1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        /*
        List<Integer> temp = new ArrayList<>();
        temp.add(8);
        temp.add(9);
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
        System.out.println(ms.ClosesNeighbors(list, 4));
        */
        closestRestaurants ms = new closestRestaurants();
        int[] array = new int[]{1,1,3,1};
        int[] array1 = new int[]{2,2,1,4};
        int[] array2 = new int[]{5,1,2};
        System.out.println(ms.mexHeightStack(array, array1, array2));
    }
}
