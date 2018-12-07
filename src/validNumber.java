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

    public ArrayList<String> restoreIpAddresses(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() > 12) {
            return null;
        }

        return null;
    }


    public String getValidIp(String str) {
        int count = 3;
        StringBuilder sb  = new StringBuilder();

        StringBuilder s = new StringBuilder();
        for(int j = 0; j <= count; j++) {
            s.append(str.substring(j, j + 3));
            s.append('.');
        }
        sb.append(s.toString().substring(0, s.length() -2));
        return sb.toString();
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
            if (str.charAt(i) == ' ' || (Character.isDigit(str.charAt(i)) && str.charAt(i) != 'e' && str.charAt(i) != '.' || str.charAt(i) == '-')) {
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


    public boolean isValidNumber2(final String input) {
        String str = input.trim();
        for(int i =0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {

            }
        }
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
        System.out.println(vs.isValidNumber(str));

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("stsdfd", "dfdad"));

        System.out.println(vs.restoreIpAddresses("25525511135"));
    }
}
