public class KMPAlgo {


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
        System.out.println(kmp.KMPalgo(str, ptr));
    }
}
