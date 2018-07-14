public class KMPAlgo {


    // Knuth morris pratt algorithm
    public static boolean KMPalgo(String text, String pattern) {

    }

    public int[] computeArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < pattern.length) {
            if(pattern[index] == pattern[i]) {
                index++;
                i++;
            }
        }
    }



    public static void main(String[] args) {
        KMPAlgo kmp = new KMPAlgo();
    }
}
