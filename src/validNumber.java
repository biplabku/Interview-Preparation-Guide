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
        String str = input.trim();      // Removing the trailing white spaces from the string
        int expIndex = -1;
        int dotIndex = -1;
        if(str.length() ==0) {
            return false;
        }
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                dotIndex = i;
                continue;
            }else if(str.charAt(i) == 'e') {
                expIndex = i;
                continue;
            }else if(Character.isAlphabetic(str.charAt(i))) {
                return false;
            }else if(str.charAt(i) == '+') {
                return false;
            }
        }
        if(dotIndex == -1 && expIndex == -1) {
            return true;
        }
        if(dotIndex == 0 || dotIndex + 1 == expIndex || expIndex + 1 == dotIndex) {
            return false;
        }
        return true;
    }

    // This solution will experience runtime error for larger values
    public int compareVersionNumbers(String str1, String str2) {
        String[] arr1 = str1.split("\\.");
        String[] arr2 = str2.split("\\.");
        int len = Math.min(arr1.length, arr2.length);

        int i;
        int j;
        for( i = 0, j = 0; i < len; i++, j++) {
            int val1 = Integer.parseInt(arr1[i]);
            int val2 = Integer.parseInt(arr2[j]);
            if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                return 1;
            }else if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                return -1;
            }else if(Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[i])){
                continue;
            }
        }

        if(j < arr2.length) {
            return -1;
        }else if(i < arr1.length) {
            return 1;
        }
        return 0;
    }


    public boolean checkPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equalsIgnoreCase(str);
    }

    public String longPalindrome(String str) {
        String res = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j <= str.length(); j++) {
                String temp = str.substring(i, j);
                if(checkPalindrome(temp)) {
                    if(res.length() < temp.length()) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }


    public String longPalindromeMethod2(String str) {
        int n = str.length();
        int start = 0;
        int maxlength = 1;
        int low;
        int high;
        for(int i = 1; i < n; i++) {
            low = i-1;
            high = i;
            while(low >= 0 && high < n && str.charAt(low) == str.charAt(high)){
                if(high - low + 1 > maxlength) {
                    start = low;
                    maxlength = high - low + 1;
                }
                --low;
                ++high;
            }

            low = i -1;
            high = i + 1;
            while(low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                if(high - low + 1 > maxlength) {
                    start = low;
                    maxlength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        return str.substring(start, start + maxlength);
    }

    public static void main(String[] args) {
        validNumber vs = new validNumber();
        String str  = "";
        String str1 = "1.1e-10";
        // System.out.println(Integer.valueOf("1"));
        // System.out.println(vs.longPalindromeMethod2("aaaabaaa"));
        System.out.println(vs.compareVersionNumbers("13.0", "13.0"));
    }
}
