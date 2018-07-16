import java.util.*;

public class KMPAlgo {


    // find anagrams
    public List<String> findAnagrams(List<String> anagrams) {
        HashMap<String, List<String>> sortedStrings = new HashMap<>();
        for(String s: anagrams) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = arr.toString();
            if(!sortedStrings.containsKey(str)) {
                sortedStrings.put(str, new ArrayList<>());
            }else {
                sortedStrings.get(str).add(s);
            }
        }
        List<String> List = new ArrayList<>();
        return List;
    }

    // compress and decompress string
    // Input String  == 3[abc]4[ab]c
    // Output String == abcabcabcababababc
    // I have to start from the right side instead of the left side of the string
    // Since it gives how many times the character or String needs to be repeated
    // I can use recursion here
    public String compressDecompress(String inputString) {
        for(int i = 0; i < inputString.length(); i++) {
            if(Character.isDigit(inputString.charAt(i))) {
                System.out.println(inputString.charAt(i));
            }
        }
        return "Done";
    }

    // Knuth morris pratt algorithm
    public  boolean KMPalgo(String txt, String ptr) {
        char[] text = txt.toCharArray();
        char[] pattern = ptr.toCharArray();
        int i = 0;
        int j = 0;
        int[] lps = computeArray(pattern);
        while(i < txt.length() && j < ptr.length()) {
            if(text[i] == pattern[j]) {
                i++;
                j++;
            }else {
                if(j != 0) {
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }
        if(j == pattern.length) {
            return true;
        }
        return false;
    }

    public  int[] computeArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < pattern.length;) {
            if(pattern[index] == pattern[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            }else {
                if(index != 0) {
                    index = lps[index - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }



    public static void main(String[] args) {
        KMPAlgo kmp = new KMPAlgo();
        String str = "abcxabcdabcdabcy";
        String ptr = "abcdabcs";
        // System.out.println(kmp.KMPalgo(str, ptr));
        String str1 = "3[abs]4[ab]c";
        String str2 = "2[3[a]b]";
        System.out.println(kmp.compressDecompress(str2));
    }
}
