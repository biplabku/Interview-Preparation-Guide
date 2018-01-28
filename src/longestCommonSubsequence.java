public class longestCommonSubsequence {


    public static int findComSequence(String S, String T) {
         return LCS(S, T, S.length(), T.length());
    }

    public static int LCS(String str, String ptr, int m, int n) {
        if(m == 0 || n == 0) {
            return  0;
        }
        if(str.charAt(m - 1) == ptr.charAt(n - 1)) {
            return  1 + LCS(str, ptr, m -1, n-1);
        }else {
            return Math.max(LCS(str, ptr, m, n-1), LCS(str, ptr, m-1, n));
        }
    }


    public static void main(String[] args) {

        String S = "AGGTAB";
        String T = "GXTXAYB";
        System.out.println(findComSequence(S, T));
    }
}
