import java.util.*;

public class KClosesPoints {


    public int[][] kclosestPointsThere(int[][] points, int k) {
        int[][] result = new int[k][2];
        int len = k;
        TreeMap<Integer, LinkedList<Points>> tmap = new TreeMap<>();

        for(int i = 0; i < points.length; i++) {
            Points temp = new Points(points[i][0], points[i][1]);
            int val = calcDistance(temp.x, temp.y);
            if(!tmap.containsKey(val)) {
                LinkedList<Points> list = new LinkedList<>();
                list.add(temp);
                tmap.put(val, list);
            }else {
                tmap.get(val).add(temp);
            }
        }
        Iterator iter = tmap.entrySet().iterator();
        LinkedList<Points> temp = new LinkedList<>();
        while(iter.hasNext() && temp.size() != k) {
            Map.Entry pair = (Map.Entry) iter.next();
            LinkedList<Points> list = (LinkedList)pair.getValue();
            temp.addAll(list);
        }
        for(int i = 0; i < temp.size() && i < len; i++) {
            Points p2 = temp.get(i);
            result[i][0] = p2.x;
            result[i][1] = p2.y;

        }

        return result;
    }

    public int calcDistance(int x, int y) {
        return (int)Math.sqrt((x )*(x) + (y ) * (y ));
    }

    public static class Points {
        int x;
        int y;

        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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


    public double medianOfSorted(List<Integer> list1, List<Integer> list2) {
        double res = 0;
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < list1.size() && index2 < list2.size()) {
            if(list1.get(index1) <= list2.get(index2)) {
                list.add(list1.get(index1));
                index1++;
            }else if(list1.get(index1) > list2.get(index2)) {
                list.add(list2.get(index2));
                index2++;
            }
        }
        while(index1 < list1.size()) {
            list.add(list1.get(index1));
            index1++;
        }
        while(index2 < list2.size()) {
            list.add(list2.get(index2));
            index2++;
        }

        if(list.size() == 1) {
            return (double)list.get(0);
        }
        int n = list.get(list.size()/2);
        int l = list.get(list.size()/2 + 1);
        if(list.size() % 2 == 0) {
            res = (double)(n + l) /2;
            return res;
        }
        res = (double)(list.get(list.size()/2));
        return res;
    }

    public int KthSmallestGivenSize() {
        return 1;
    }


    public class KNode{
        int size;
        int val;
        public KNode leftChild;
        public KNode rightChild;
    }


    public String[] findRelativeRanks(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], i);
            }
        }
        int count = 0;
        String[] result = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                result[count] = "Gold Medal";
            }else if(i == 1) {
                result[count] = "Silver Medal";
            }else if(i == 2) {
                result[count] = "Bronze Medal";
            }else {
                result[count] = Integer.toString(i + 1);
            }
            count++;
        }
        return result;
    }


    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        int len = k;
        TreeMap<Integer, LinkedList<Points>> tmap = new TreeMap<>();

        for(int i = 0; i < points.length; i++) {
            Points temp = new Points(points[i][0], points[i][1]);
            int val = calcDistance1(temp.x, temp.y);
            if(!tmap.containsKey(val)) {
                LinkedList<Points> list = new LinkedList<>();
                list.add(temp);
                tmap.put(val, list);
            }else {
                tmap.get(val).add(temp);
            }
        }
        Iterator iter = tmap.entrySet().iterator();
        LinkedList<Points> temp = new LinkedList<>();
        while(iter.hasNext() && temp.size() != k) {
            Map.Entry pair = (Map.Entry) iter.next();
            LinkedList<Points> list = (LinkedList)pair.getValue();
            temp.addAll(list);
        }
        for(int i = 0; i < temp.size() && i < len; i++) {
            Points p2 = temp.get(i);
            result[i][0] = p2.x;
            result[i][1] = p2.y;
        }

        return result;
    }

    public int calcDistance1(int x, int y) {
        return (int)Math.sqrt((x )*(x) + (y ) * (y ));
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
        int[] array = {10,3,8,9,4};
        System.out.println(ls.getSum(array, 5));
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);

        int[][] array1 = {{-5,4}, {-6,-5},{4,6}};
        System.out.println(ls.kclosestPointsThere(array1, 2));
        // System.out.println(ls.numOfSegments("My name is Biplab"));
    }
}
