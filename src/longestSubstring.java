import java.util.HashMap;

public class longestSubstring {

    // Given a string s, find the length of the longest
    // substring
    // without repeating characters.
    // str = abcabcbb
    // abc, abc, cab,cb, bca,

    // i =0, a, 1 == max = i - startIndex + 1
    // i =1, b, 2 == max = 2
    // i =2, c, 3 == max = 3
    // i =4, a,

    public static int lengthOflongestSubstring(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        int max = 0;
        int startIndex = 0;
        HashMap<Character, Integer> hmap =new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hmap.containsKey(ch)) {
                startIndex = Math.max(hmap.get(ch), startIndex);
            }
            hmap.put(ch, i + 1);
            max = Math.max(max, i - startIndex + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(lengthOflongestSubstring(str));
    }
}
