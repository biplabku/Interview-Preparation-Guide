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

    // I = 1
    // V = 5

    // X = 10
    // L = 50

    // C = 100
    // D = 500

    // M = 1000

    // 421 = CDXXI
    // CDXXI = 100 - 500 = 400
    // DCXXI = 500 + 100 = 600
    // 51 = LI
    public int doRomanToInt(String str) {
        int result = 0;
        int i = 0;
        for(i = 0; i < str.length() -1; i = i + 2) {
            char firstChar = str.charAt(i);
            char seconChar = str.charAt(i + 1);
            if(getValue(firstChar) >= getValue(seconChar)) {
                result += getValue(firstChar) + getValue(seconChar);
            } else {
                result += getValue(seconChar) - getValue(firstChar);
            }
            System.out.println(result + " Va " + firstChar + seconChar + "  i  value " + i);
        }

        // result += getValue(str.charAt(str.length() - 1));
        // result = Math.abs(result);
        System.out.println(i + " value " ) ;

         if(getValue(str.charAt(i -1)) >= getValue(str.charAt(i))) {
            result += getValue(str.charAt(i -1)) + getValue(str.charAt(i));
        }else {
            result += getValue(str.charAt(i)) - getValue(str.charAt(i -1));
        }
        return result;
    }

    public int getValue(char ch) {
        if(ch == 'V') {
            return 5;
        }else if(ch == 'X') {
            return 10;
        }else if(ch == 'L') {
            return 50;
        }else if(ch == 'C') {
            return 100;
        }else if(ch == 'D') {
            return 500;
        }else if(ch == 'M') {
            return 1000;
        }
        return 1;
    }


    public int romanToInt(String str) {
        int result = 0;
        int len = str.length();
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

    public  int getHCD(int[] array) {
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int res = 1;
        int counter = 0;
        for(int i = 1; i <= max; i++) {
            while(array[counter] % i  == 0) {
                counter++;
            }
            if(counter == array.length) {
                res = i;
            }
        }
        return res ;
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
        String str = "MDCCCIV";
        // System.out.println(ms.romanToInt(str));
        // System.out.println(ms.doRomanToInt(str));
        int[] arr = new int[]{2,3,6,8,10};
        System.out.println(ms.getHCD(arr));
    }
}
