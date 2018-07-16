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
        String[] arr = inputString.split("]");
        String str = "3[abc]4[ab]c";
        String[] arr1 = str.split("]");
        System.out.println(arr1[0] +  " " + arr1[1] + " " + arr1[2]);
        System.out.println(arr[0] + " " + arr[1]);
        StringBuilder sb = new StringBuilder();
        for(int i = arr1.length - 1; i >= 0; i--) {
            String s = arr1[i];
            // get the number and then append the string as many times
            int count = 0;
            while(Character.isDigit(s.charAt(i))) {
                count++;
            }

        }
        return "Done";
    }

    public String doCompress(String str) {
        StringBuilder sb1 = new StringBuilder();
        int len = str.length() - 1;
        while(len != 1) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(len) != '[') {
                sb.append(str.charAt(len));
                len = len - 1;
            }
            System.out.println(len);
            int right = len;
            int left = len;
            while(len != 0 && Character.isDigit(str.charAt(len))) {
                left = len;

                len = len - 1;
            }
            String countStr = str.substring(left, right);

            System.out.println(countStr  + " Stromg" + left  + " " + right);

            String temp = sb.toString();
            /*
            while(count != 0) {
                sb1.append(sb.toString());
            }
            */
        }
        return sb1.toString();
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
        // System.out.println(kmp.compressDecompress(str2));
        System.out.println("The compress value -- > " + kmp.doCompress("3[abc"));
    }
}
