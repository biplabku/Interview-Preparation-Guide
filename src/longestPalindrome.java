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


    public static void main(String[] args) {
        String str = "aa";
        // System.out.println(getLongestPalindromeSubstring(str));
        // System.out.println(isPalindrome(str, 0, 5));

        System.out.println(isPalindrome1(str));
    }
}
