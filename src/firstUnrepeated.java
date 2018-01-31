import java.util.HashMap;
import java.util.HashSet;

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

    public static void main(String[] args) {

        String str = "leetcodel";
        System.out.println(findUnrepeatedChar(str));
    }
}
