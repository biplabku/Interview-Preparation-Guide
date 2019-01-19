import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTutorials {

    // LinkedHashMap is a common implementation of Map interface
    // It is similar to HashMap in most aspects. However, the linked hashmap is
    // based on both hash table and linked list to enhance the functionality of the
    // hashmap
    public void linkedHashMap( ) {
        LinkedHashMap<Integer, String> hmap = new LinkedHashMap<>();
        for(int i = 0; i < 4; i++) {
            hmap.put(5, "apple");
            hmap.put(1, "mango");
            hmap.put(1, "tango");
        }
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            System.out.println((int)pair.getKey());
        }
    }

    public static void main(String[] args) {
        MapTutorials ms = new MapTutorials();
        ms.linkedHashMap();
    }
}
