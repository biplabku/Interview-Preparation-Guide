import java.util.ArrayList;
import java.util.Arrays;

public class validNumber {
    // Given a string containing only digits, restore it by returning all possible valid IP
    // address combinations.
    // A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers
    // from 0-255. The numbers cannot be 0 prefixed unless they are 0.

    // Example:

    // Given “25525511135”,

    //        return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned
    // strings are sorted in order)
// comparng every section and then checkjjng if its valid and only after every section is verfified we add it
    // to the container list.
    public ArrayList<String> restoreIpAddresses(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() < 4 || str.length() > 12) {
            return list;
        }
        int len = str.length();
        for(int i = 1; i < 4 && i < len - 2; i++) {            // end for the first loop

            for(int j = i + 1; j < i + 4 && j < len -1; j++) { // end for the second loop

                for(int k = j + 1; k < j + 4 && k < len; k++) {

                    String first = str.substring(0, i);
                    String second = str.substring(i, j);
                    String third = str.substring(j, k);
                    String fourth = str.substring(k);
                    System.out.println(first + " " + second + " " + third + " " + fourth);
                    if(checkValidity(first) && checkValidity(second) && checkValidity(third) && checkValidity(fourth)) {
                        list.add(first + '.' + second + '.' + third + '.' + fourth) ;
                    }

                }
            }
        }
        return list;
    }


    public boolean checkValidity(String str) {
        if((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }


    // get the String and then find the valid number from the given String
    // -1.1e-10
    public boolean isValidNumber(final String input) {
        boolean result = false;
        boolean seenExp = false;
        boolean seenDot = false;
        boolean seenNeg = false;
        String str = input.trim();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || (Character.isDigit(str.charAt(i)) && str.charAt(i) !=
                    'e' && str.charAt(i) != '.' || str.charAt(i) == '-')) {
                return false;
            } else if (str.charAt(i) == '.') {
                if (seenExp) {
                    return false;
                } else {
                    seenDot = true;
                }
            } else if (str.charAt(i) == 'e') {
                if (seenDot) {
                    return false;
                }
            } else if(str.charAt(i) == '-') {

            }
        }
        return result;
    }

    // inputs - containing only digits
    public boolean isValidNumber2(final String input) {
        String str = input.trim();

        return true;
    }
    

    public static void main(String[] args) {
        validNumber vs = new validNumber();
        String str  = "";
        // 1.1e13
        // e-13
        // -1e-13
        // 1e12
        String str1 = "1.1e-10";
        // System.out.println(vs.isValidNumber(str));
        System.out.println(vs.restoreIpAddresses("25525511135"));
    }
}
