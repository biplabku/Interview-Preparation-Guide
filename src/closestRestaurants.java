import java.util.*;

public class closestRestaurants {

    public int[][] kClosest(int[][] points, int k) {
        int[][] results = new int[k][2];
        HashMap<Point, Integer> hmap = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            int val = calcDistance(p.x, p.y);
            hmap.put(p, val);
        }
        // Convert map to list
        List<Map.Entry<Point, Integer>> list = new LinkedList<Map.Entry<Point, Integer>>(hmap.entrySet());

        // sort the list with a comparator
        Collections.sort(list, new Comparator<Map.Entry<Point, Integer>>() {
            @Override
            public int compare(Map.Entry<Point, Integer> o1, Map.Entry<Point, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        HashMap<Point, Integer> sort = new LinkedHashMap<>();
        for(Map.Entry<Point, Integer> entry : list) {
            sort.put(entry.getKey(), entry.getValue());
        }
        Iterator iter = sort.entrySet().iterator();
        int i = 0;
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            Point p = (Point)pair.getKey();
            results[i][0] = p.x;
            results[i][1] = p.y;
            i++;
            if(i == k) {
                break;
            }
        }
        return results;
    }
    public int calcDistance(int x, int y) {
        return (int)Math.sqrt((x)* (x) + (y)* (y));
    }
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



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


    public int mexHeightStack(int[] array1, int[] array2, int[] array3) {
        cumulativeSum(array1);
        cumulativeSum(array2);
        cumulativeSum(array3);
        int index1 = array2.length - 1;
        int index2 = array3.length - 1;
        int max = 0;
        for(int i = array1.length - 1; i >= 0; i--) {
            int el = array1[i];
            while(index1 > 0 && el < array2[index1] ) {
                index1--;
            }
            while(el < array3[index2] && index2 > 0) {
                index2--;
            }
            if(index1 < 0 && index2 >= 0 || index1 >=0 && index2 < 0) {
                index1 = array2.length - 1;
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
        int[][] input = new int[][] {{3,3},{5,-1}, {-2,4}};
        int[][] temp = ms.kClosest(input, 2);
        for(int i =0 ; i < temp.length; i++) {
            System.out.println(temp[i][0] + " " + temp[i][1]);
        }
        // System.out.println(ms.kClosestPoints(input, 2));
    }
}
