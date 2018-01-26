public class linkListPalindrome {

    public static boolean linkListPalindrome(LinkNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.data);
            head = head.next;
        }
        return isPalindrome(sb.toString());
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        while(i < str.length()/2) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "aab";
        System.out.println(linkListPalindrome(str));
    }

}
