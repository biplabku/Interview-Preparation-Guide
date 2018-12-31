import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class sortStringwithString {



    public String sortString(String str1, String str2) {
        HashMap<Character, String> hmap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hmap2 = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, Character.toString(ch));
            }else {
                hmap.put(ch, hmap.get(ch) + ch);
            }
        }

        for(int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if(hmap.containsKey(ch)) {
                result.append(hmap.get(ch));
            }
        }

        for(int i = 0 ; i < str2.length(); i++) {
            Character ch = str2.charAt(i);
            if(!hmap2.containsKey(ch)) {
                hmap2.put(ch, 1);
            }
        }

        for(int i = 0 ; i < str1.length(); i++) {
            Character ch = str1.charAt(i);
            if(!hmap2.containsKey(ch)) {
                result.append(ch);
            }
        }
        // lets handle the edge case

        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = "aaebacde";
        String str2 = "badc";
        sortStringwithString ss = new sortStringwithString();
        System.out.println(ss.sortString(str1, str2));
    }
}
