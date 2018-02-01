import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SumOnFind {

    public static HashMap<Integer, Integer> hmap = new HashMap<>();

    public void SumOnFind() {

    }

    public static void add(int number) {
        if(!hmap.containsKey(number) ) {
            hmap.put(number, 1);
        }else {
            hmap.put(number, hmap.get(number) + 1);
        }
    }

    public static boolean find(int value) {
        Iterator it = hmap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int key = (int) pair.getKey();
            int diff = value - key;
            if (key == diff && (int) pair.getValue() > 1 || (key != diff) && hmap.containsKey(diff)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        add(1);
        add(3);
        add(5);
        System.out.println(find(4));
    }
}
