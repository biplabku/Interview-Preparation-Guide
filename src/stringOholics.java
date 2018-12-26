import java.util.*;

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

    public int solveString(ArrayList<String> list) {
        int i =(int) Math.pow(10,2);
        int count = 0;
        int res = 0;
        int size = 0;
        while(i != 0) { // this will be the main counter;
            while(size != list.size() - 1) {
                String str = list.get(size);
                if (count != str.length()) {
                    if (str.equalsIgnoreCase(getRotateString(str, count))) {
                        res++;
                    }
                    count++;
                } else if (count == str.length()) {
                    count = 0;
                }
                i--;
            }
        }
        return res;
    }

    // next implementation is how to find the minimum number of times the maximum number of string are
    // equal.




    public static void main(String[] args) {
        stringOholics ss = new stringOholics();
        String str = "abcd";
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abcd", "abc", "bda"));
        System.out.println(ss.solveString(list));
    }
}
