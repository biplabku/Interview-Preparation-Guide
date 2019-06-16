import java.util.*;

public class firstUnrepeated {


    public static int findUnrepeatedChar(String str) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(!hs.containsKey(str.charAt(i))) {
                hs.put(str.charAt(i), 1);
            }else {
                hs.put(str.charAt(i) , hs.get(str.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < str.length(); i++ ) {
            if(hs.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // count primes problem
    public int countPrimes(int number) {
        if(number <= 2) {
            return 0;
        }
        int res = 0;
        for(int i = 2; i < number; i++) {
            if(checkPrime(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean checkPrime(int number) {
        for(int i = 2; i < number; i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }


    public void iterateHashMap() {
        HashMap<Integer, String> hmap = new HashMap<>();
        // enter some random data.
        hmap.put(1, "Apple");
        hmap.put(2, "Mango");
        hmap.put(3, "Pineapple");


        // what does iterator means ?
        // Its like a pointer that can refer to a data structure and iterate over it
        // Map.Entry is a map entry (key-value pair). And the map.entryset method returns a
        // a collection view of the map whose elements are of this class.
        // And you can only access the map is to refer to the iterator of the same map

        // Method 1. Using EntrySet and Iterator
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            int key = (int)pair.getKey();
            String value = (String)pair.getValue();
            // System.out.println(key + " " + value + " 1 ");
        }

        // Method 2. Using KeySet
        for(Integer integer : hmap.keySet()) {
            int key = integer;
            String value = hmap.get(integer);
            // System.out.println(key + " " + value + " 2");
        }

        // Method 3. Using KeySet and Iterator
        Set<Integer> keyset = hmap.keySet();
        Iterator<Integer> iter1 = keyset.iterator();
        while(iter1.hasNext()) {
            int key = (iter1.next());
            String value = hmap.get(key);
            System.out.println(key + " " + value + " 3");
        }
        
    }

    public static void main(String[] args) {

        String str = "leetcodel";
        //System.out.println(findUnrepeatedChar(str));
        firstUnrepeated gs = new firstUnrepeated();
        gs.iterateHashMap();
        System.out.println(gs.countPrimes(5));
    }
}
