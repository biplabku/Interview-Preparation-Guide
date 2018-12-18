import java.math.BigInteger;
import java.util.Arrays;

public class mulString {


    public String multiplyString(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int counter = 0;
        // 000
        while(str1.charAt(counter) == '0') {
            counter++;
            if(counter == str1.length()) {
                return "0";
            }
        }
        sb1.append(str1.substring(counter, str1.length()));
        counter = 0;
        while(str2.charAt(counter) == '0') {
            counter++;
            if(counter == str2.length()) {
                return "0";
            }
        }
        sb2.append(str2.substring(counter, str2.length() ));
        long a = Long.parseLong(sb1.toString());
        long b = Long.parseLong(sb2.toString());
        String res = Long.toString(a * b);
        return res;
    }

    public String mulString( String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        int counter = 0;
        while(str1.charAt(counter) == '0') {
            counter++;
            if(counter == str1.length()) {
                return "0";
            }
        }
        str1 = str1.substring(counter, str1.length());
        counter = 0;
        while(str2.charAt(counter) == '0') {
            counter++;
            if(counter == str2.length()) {
                return "0";
            }
        }
        str2 = str2.substring(counter, str2.length());
        //  Now the multiplication part of the algorithm
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        // find the bigger length number from the string
        String big = "";
        String small = "";
        if(str1.length() > str2.length()) {
            big = str1;
            small = str2;
        }else if(str1.length() == str2.length()) {
            small = str1;
            big = str2;
        }
        else {
            small = str2;
            big = str1;
        }
        int carry = 0;
        int base = 0;
        int len = 0;

        System.out.println(small + " df " + big);
        int[] pos = new int[str1.length() + str2.length()];
        Arrays.fill(pos, 0);
        for(int i = 0; i < big.length(); i++) {
            for(int j = 0; j < small.length(); j++) {
                int k = i + j;
                int ch1 = big.charAt(i) - '0';
                int ch2 = small.charAt(j) - '0';
                int mul = (ch1) * (ch2) + carry + pos[k];
                carry = mul/10;
                base = mul % 10;
                pos[k] = base;
                len = k;
            }
            if(carry > 0) {
                pos[len + 1] = carry;
                carry = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= len + 1 ; i++) {
            sb.append(pos[i]);
        }
        String res = sb.reverse().toString();
        if(res.charAt(0) == '0') {
            res = res.substring(1, res.length());
        }
        return res;
    }

    public static void main(String[] args) {
        mulString ms = new mulString();
        String str1 = "5";
        String str2 = "7";
        System.out.println(ms.mulString(str1, str2));
    }
}
