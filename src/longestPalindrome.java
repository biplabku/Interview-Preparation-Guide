public class longestPalindrome {


    public static String getLongestPalindromeSubstring(String str) {
        if(str.length() < 2) {
            return str;
        }
        String res = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                if(isPalindrome(str, i, j) && (res.length() <= (j - i))) {
                    res = str.substring(i, j);
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String str, int left, int right) {
        for(int i = left; i < right; i++) {
            if(str.charAt(i) != str.charAt(right - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String getLongestPalindromeSubstringMethod2(String str) {
        String res = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j <= str.length(); j++) {
                if(isPalindrome1(str.substring(i, j))) {
                    res = res.length() < str.substring(i, j).length() ? str.substring(i, j) : res;
                }
            }
        }
        return res;
    }
    // expand around center - O(N2)
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean [][] dp = new boolean[len][len];

        String longest = null;
        for(int l=0; l<s.length(); l++){
            for(int i=0; i<len-l; i++){
                int j = i+l;
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;

                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }

        return longest;
    }


    public static String longestPalindromeE(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        String str = "babd";
        // System.out.println(getLongestPalindromeSubstring(str));
        // System.out.println(isPalindrome(str, 0, 5));

        //System.out.println(isPalindrome1(str));
        // System.out.println(getLongestPalindromeSubstringMethod2(str));
        System.out.println(longestPalindromeE(str));
    }
}
