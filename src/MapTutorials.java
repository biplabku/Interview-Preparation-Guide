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

    public static void main(String[] args) {
        MapTutorials ms = new MapTutorials();
        ms.linkedHashMap();
    }
}
