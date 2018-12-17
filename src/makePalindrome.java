import java.util.ArrayList;

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

    // Be careful about the edge cases for implementing this solution
    // XXXIV
    public int romanToInt(String str) {
        int result = 0;
        // final length should define how the values should be added
        int len = str.length();
        boolean seenD = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'X') {
                result += 10;
            }else if(str.charAt(i) == 'M') {
                result += 10;
            }else if(str.charAt(i) == 'C') {
                result += 100;
            }else if(str.charAt(i) == 'L') {
                result += 10;
            }else if(str.charAt(i) == 'I') {
                if(i < str.length() -1) {
                    if(str.charAt(i + 1) == 'V') {
                        result += -1;
                    }else if(str.charAt(i -1) == 'V'){
                        result += 1;
                    }
                }else if(i == str.length() -1) {
                    result += 1;
                }
            }else if(str.charAt(i) == 'V') {
                result += 5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        makePalindrome ms   = new makePalindrome();
        /*
        System.out.println(ms.makePalindromicString("aaaaa"));

        ArrayList<String> list = new ArrayList<>();
        list.add("abcdefgh");
        list.add("aefghijk");
        list.add("abcefgh");
        */
        String str = "VIII";
        System.out.println(ms.romanToInt(str));
    }
}
