import javax.swing.text.MutableAttributeSet;
import java.math.BigInteger;
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

    public int compareStringVersions(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();

        String[] arr1 = str1.split("\\.");
        String[] arr2 = str2.split("\\.");

        int i;
        int j;
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(arr1[arr1.length - 1].equalsIgnoreCase("0")) {
            len1 = arr1.length - 2;
        }else if(arr2[arr2.length - 1].equalsIgnoreCase("0")){
            len2 = arr2.length - 2;
        }
        int comLength = Math.min(len1, len2);
        for(i = 0, j =0; i < comLength && j < comLength; i++, j++  ) {
            String s1 = arr1[i];
            String s2 = arr2[j];
            if(s1.equalsIgnoreCase("0") && s2.equalsIgnoreCase("0")) {
                continue;
            }
            int val = comparison(s1, s2);
            if(val == 1) {
                return 1;
            }else if(val == -1) {
                return -1;
            }else if(val == 0) {
                continue;
            }
        }

        if(i < arr1.length) {
            return 1;
        }else if(j < arr2.length) {
            return -1;
        }
        return 0;
    }
    public int comparison(String str1, String str2) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(str1.charAt(count) == '0' && count < str1.length()) {
            count++;
        }
        i = count;
        count = 0;
        while(str2.charAt(count) == '0' && count < str2.length()) {
            count++;
        }
        j = count;
        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }else if(Character.getNumericValue(str1.charAt(i)) > Character.getNumericValue(str2.charAt(j))) {
                return 1;
            }else if(Character.getNumericValue(str1.charAt(i)) < Character.getNumericValue(str2.charAt(j))) {
                return -1;
            }
        }
        if(i < str1.length()) {
            return 1;
        }else if(j < str2.length()){
            return -1;
        }
        return 0;
    }


    // This solution will experience runtime error for larger values
    public int compareVersionNumbers(String str1, String str2) {
        System.gc();
        String[] arr1 = str1.split("\\.");
        String[] arr2 = str2.split("\\.");
        int len = Math.min(arr1.length, arr2.length);

        int i;
        for( i = 0; i < len; i++) {

            BigInteger b1 = BigInteger.valueOf(Long.parseLong(arr1[i]));
            BigInteger b2 = BigInteger.valueOf(Long.parseLong(arr2[i]));
            int val = b1.compareTo(b2);
            if(val == 1){
                return 1;
            }else if(val == -1){
                return -1;
            }else if(val == 0){
                continue;
            }
        }
        if(i < arr1.length) {
            return 1;
        }else if(i < arr2.length) {
            return -1;
        }
        return 0;
    }

    public String getString(String str){
        int i = 0;
        while(str.charAt(i) == '0') {
            i++;
        }
        if(i > str.length()) {
            return "0";
        }else if(i > 0 && i <str.length()) {
            return str.substring(i, str.length());
        }
        return str;
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
        System.out.println(vs.compareVersionNumbers("0001", "1"));
    }
}
