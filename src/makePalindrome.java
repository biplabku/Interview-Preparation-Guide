public class makePalindrome {

    // You are given a string. The only operation allowed is to insert characters in the beginning of the string.
    // How many minimum characters are needed to be inserted to make the string a palindrome string
    // inserting the number of characters to make a string palindrome
    public static int makePalindromicString(String str) {
        int size = str.length() - 1;
        StringBuilder sb1 = new StringBuilder(str);
        if(sb1.toString().equalsIgnoreCase(sb1.reverse().toString())){
            return 0;
        }
        while(size != 0) {
            StringBuilder temp = new StringBuilder(str.substring(size));
            StringBuilder sb = new StringBuilder(temp.reverse().toString() + str);
            if(sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
                return str.length() - size;

            }
            size--;
        }
        return 0;
    }

    public static void main(String[] args) {
        makePalindrome ms   = new makePalindrome();
        System.out.println(ms.makePalindromicString("aaaaa"));
    }
}
