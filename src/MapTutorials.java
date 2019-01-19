import java.util.*;

public class MapTutorials {

    // LinkedHashMap is a common implementation of Map interface
    // It is similar to HashMap in most aspects. However, the linked hashmap is
    // based on both hash table and linked list to enhance the functionality of the
    // hashmap
    public void linkedHashMap( ) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(5, "apple");
        hmap.put(0, "mango");
        hmap.put(-1, "tango");
        hmap.put(9, "apple");
        hmap.put(10, "mango");
        hmap.put(8, "tango");
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            System.out.println((int)pair.getKey());
        }
        System.out.println("done");

        LinkedHashMap<Integer, String> tmap = new LinkedHashMap<>();
        tmap.put(5, "apple");
        tmap.put(0, "mango");
        tmap.put(-1, "tango");
        tmap.put(9, "apple");
        tmap.put(10, "mango");
        tmap.put(8, "tango");
        Iterator iter1 = tmap.entrySet().iterator();
        while(iter1.hasNext()) {
            Map.Entry pair = (Map.Entry) iter1.next();
            System.out.println((int)pair.getKey());
        }
    }

    public int majorityElement(List<Integer> list) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i =0; i< list.size(); i++) {
            if(!hmap.containsKey(list.get(i))) {
                hmap.put(list.get(i), 1);
            }else {
                hmap.put(list.get(i), hmap.get(list.get(i)) + 1);
            }
        }
        int max = 0;
        int res = 0;
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            int val = (int)pair.getValue();
            if(max < val) {
                max = val;
                res = (int)pair.getKey();
            }
        }

        if(max > list.size()/2) {
            return res;
        }
        return -1;
    }

    public int majorityElementMethod2 (List<Integer> list) {
        int maj = list.get(0);
        int count = 1;
        int maj_index = 0;
        int i;
        for(i = 1; i < list.size(); i++) {
            if(maj == list.get(i)) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                maj = list.get(i);
                maj_index = i;
                count = 1;
            }
        }
        return list.get(maj_index);
    }


    public static void main(String[] args) {
        MapTutorials ms = new MapTutorials();
        // ms.linkedHashMap();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(ms.majorityElementMethod2(list));
    }
}
