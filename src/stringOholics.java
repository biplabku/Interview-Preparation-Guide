import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class stringOholics {

    // you are given an array A consisting of strings made up of the letters 'a' and 'b' only.
    // each string goes through a number of operations
    // time 1, circularly rotate each string by 1 letter

    public int getStringRepeats(final String str) {
        // lets first come up the algorithm
        char[] ar = str.toCharArray();
        List<Character> list = new LinkedList<>();
        return -1;
    }

    // abcd
    // dabc -1
    // cdab
    public String getRotateString(String str, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        str = sb.toString();
        sb.setLength(0);
        String t1 = str.substring(index);
        String t2 = str.substring(0, index);
        String res = str.substring(index) + str.substring(0, index);
        sb.append(res);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        stringOholics ss = new stringOholics();
        String str = "abcd";
        System.out.println(ss.getRotateString(str, 5));
    }
}
