import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class stringOholics {


    //////////// QUESTION /////////////
    //       https://www.interviewbit.com/problems/stringoholics/
    //////////// END /////////////
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


    // you are given an array A consisting of strings made up of the letters 'a' and 'b' only.
    // each string goes through a number of operations
    // time 1, circularly rotate each string by 1 letter

    public int getStringRepeats(ArrayList<String> input) {
        int len = input.size();
        for(String str: input) {
            int maxLen = findMaxLength(str);
            int n = str.length();
        }
        return -1;
    }

    public int findMaxLength(String str) {
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int len =0;
        int n = str.length();
        int i = 1;
        int max = 0;

        while(i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                max = Math.max(max, len);
            }else {
                if(len == 0) {
                    lps[i] =0;
                    i++;
                }else {
                    len = lps[len - 1];
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        stringOholics ss = new stringOholics();
        String str = "abcd";
        System.out.println(ss.getRotateString(str, 4));
    }
}
