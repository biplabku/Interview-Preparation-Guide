public class KMPAlgo {


    // Knuth morris pratt algorithm
    public static boolean KMPalgo(String text, String pattern) {

    }

    public int[] computeArray(char[] pattern) {
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
    }
}
