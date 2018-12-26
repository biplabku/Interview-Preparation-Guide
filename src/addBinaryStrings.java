import java.util.Arrays;
import java.util.LinkedList;

public class addBinaryStrings {


    public int mthToLast(LinkList list, int m) {
        if(list == null) return -1;
        LinkNode prev = list.head;
        LinkNode cur = list.head;

        int i = 0;
        while(cur.next != null) {
            if(i != m){
                i++;
            }else if(i == m) {
                prev = prev.next;
            }
            cur = cur.next;
        }
        if(i != m) {
            return -1;
        }
        return prev.data;
    }

    // adding binary strings
    // example - 100, 11  -- > 111
    public String  addBinary(String str1, String str2) {
        // removing the whitespaces from both the strings
        str1 = new StringBuilder(str1.trim()).reverse().toString();
        str2 = new StringBuilder(str2.trim()).reverse().toString();

        StringBuilder result = new StringBuilder();
        // first question is how to handle the different length of strings
        // get the common length of the string and find the highest length of the string
        int minLength = Math.min(str1.length(), str2.length());
        int carry = 0;
        int sum = 0;
        int i = 0;
        for(i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if((ch1 == '0' && ch2 == '1' && carry != 1) ||
                    (ch1 == '1' && ch2 == '0' && carry != 1)) {
                sum = 1;
                result.append(sum);
            }else if((ch1 == '0' && ch2 == '0' && carry == 0)) {
                result.append(0);
            }else if((ch1 == '0' && ch2 == '0' && carry == 1)) {
                result.append(1);
            }else if(ch1 == '1' && ch2 == '1' && carry == 0) {
                sum = 0;
                carry = 1;
                result.append(sum);
            }else if(ch1 == '1' && ch2== '1' && carry == 1) {
                sum = 1;
                carry = 1;
                result.append(sum);
            }
        }
        sum = 0;
        if(i < str1.length()) {
            while(i < str1.length()) {
                if(carry == 1 && str1.charAt(i) == '1')  {
                    sum = 0;
                    carry = 1;
                    result.append(sum);
                }else if(carry == 1 && str1.charAt(i) == '0') {
                    sum = 1;
                    carry = 0;
                    result.append(sum);
                }else if(carry == 0 && str1.charAt(i) == '0') {
                    result.append(0);
                }else if(carry == 0 && str1.charAt(i) == '1') {
                    sum = 1;
                    result.append(sum);
                }
                i++;
            }
            if(carry == 1) {
                result.append(carry);
            }
        }else if(i < str2.length()) {
            if(carry == 1 && str2.charAt(i) == '1')  {
                sum = 0;
                carry = 1;
                result.append(sum);
            }else if(carry == 1 && str2.charAt(i) == '0') {
                sum = 1;
                carry = 0;
                result.append(sum);
            }else if(carry == 0 && str2.charAt(i) == '0') {
                result.append(0);
            }else if(carry == 0 && str2.charAt(i) == '1') {
                sum = 1;
                result.append(sum);
            }
            i++;
            if(carry == 1) {
                result.append(carry);
            }
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        addBinaryStrings bs = new addBinaryStrings();
        String str1 = "10";
        String str2 = "1111";
        // System.out.println(bs.addBinary(str1, str2));
        LinkList list = new LinkList();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        int m = 8;
        System.out.println(bs.mthToLast(list, m));
    }
}
