import java.util.*;

public class KClosesPoints {



    public List<List<Integer>> KClosesPoints(List<List<Integer>> list, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> resultTemp = new LinkedList<>();

        TreeMap<Integer, List<List<Integer>>> hmap = new TreeMap<>();
        for(int i = 0; i < list.size(); i++) {
            List<Integer> current = list.get(i);
            int x = current.get(0);
            int y = current.get(1);
            int distance = (int) Math.sqrt(x * x + y * y);
            List<Integer> curPoint = new LinkedList<>();
            curPoint.add(x);
            curPoint.add(y);
            if(!hmap.containsKey(distance)) {
                List<List<Integer>> temp = new LinkedList<>();
                temp.add(curPoint);
                hmap.put(distance, temp);
            }else {
                List<List<Integer>> temp = hmap.get(distance);
                temp.add(curPoint);
                hmap.put(distance, temp);
            }
        }

        Iterator iter = hmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            List<Integer> temp = (LinkedList)pair.getValue();
            resultTemp.add(temp);
        }

        for(int i = 0; i < k; i++) {
            result.add(resultTemp.get(i));
        }
        return result;
    }


    public int numOfSegments(String str) {
        str = str.trim();
        String[] array = str.split(" ");
        return array.length;
    }


    public List<List<Integer>> getSum(int[] array, int number) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int val = number - array[i];
            if(!hset.contains(val)) {
                hset.add(array[i]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                list.add(array[i]);
                if(!result.contains(list)){
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KClosesPoints ls = new KClosesPoints();
        /*
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(3);
        list.add(temp);
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(5);
        temp1.add(-1);
        list.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(-2);
        temp2.add(4);
        list.add(temp2);
        /*
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(4);
        temp3.add(1);
        list.add(temp3);
        List<Integer> temp4 = new ArrayList<>();
        temp4.add(-1);
        temp4.add(-3);
        list.add(temp4);
        */
        int[] array = {1,4,2,5,3,6,4,1,0};
        System.out.println(ls.getSum(array, 5));
        // System.out.println(ls.numOfSegments("My name is Biplab"));
    }
}
