public class longestPalindrome {


    public static String getLongestPalindromeSubstring(String str) {
        String res = "";
        for(int i =0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                if(isPalindrome(str, i, j) && (res.length() < (j - i))) {
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

    public static void main(String[] args) {
        String str = "bababa";
        System.out.println(getLongestPalindromeSubstring(str));
        //System.out.println(isPalindrome(str, 0, 5));
    }
}
