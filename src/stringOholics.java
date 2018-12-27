import java.util.*;

public class stringOholics {

    final int M = (int) 1e9+7;
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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(i != 0) {
            int size = 0;
            while(size != list.size()) {
                String str = list.get(i);
                if(i > str.length()) {
                    int counter = i%str.length();
                    if(str.equalsIgnoreCase(getRotateString(str, counter))) {
                    }
                }
            }
            /*
            if(count != str.length()) {
                if(str.equalsIgnoreCase(getRotateString(str, count))){
                    res++;
                }
                count++;
            }else if(count == str.length()) {
                count = 0;
            }
            */
            i--;
        }
        return res;
    }

    // next implementation is how to find the minimum number of times the maximum number of string are
    // equal.


    void updateLcmMap(Map<Integer, Integer> m, Integer num){

        int i = 2;

        while(i<=num && i > 1){
            int count = 0;

            while(num % i == 0){
                count++;
                num /= i;
            }

            if(count == 0){
                i++;
                continue;
            }

            if(m.containsKey(i)){
                int v = m.get(i);
                if(v < count){
                    m.put(i,count);
                }
            }
            else{
                m.put(i,count);
            }

            i++;
        }
    }

    long getLcm(ArrayList<Integer> lens){

        Map<Integer, Integer> m = new HashMap<>();

        for(Integer num : lens){
            updateLcmMap(m, num);
        }

        long prod = 1;
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){

            int k = entry.getKey();
            int v = entry.getValue();

            long p = pow(k,v) % M;

            prod = (prod * p) % M;
        }

        return prod % M;
    }

    public int solve(ArrayList<String> list) {
        ArrayList<Integer> lens = new ArrayList<>();

        for(String str:list) {
            int maxLen = maxSubstring(str);
            int n = str.length();

            if(n % (n - maxLen) == 0) {
                n -= maxLen;
            }

            long sum = 0;
            int i = 1;
            do{
                sum += i;
                i++;
            }while(sum %((long)n) != 0L);
            lens.add(i -1);
        }
        long lcm = getLcm(lens)%M;

        return (int)lcm %M;
    }

    public long pow(long a, long p) {
        long ans = 1;
        while(p > 0) {
            if(p % 2L == 1L) {
                ans = (ans*a)%M;
            }
            a = (a*a) % M;
            p /= 2;
        }
        return ans%M;
    }

    public int maxSubstring(String str) {
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int len = 0;
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
                    lps[i] = 0;
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "ababa", "aba"));
        //System.out.println(ss.solveString(list));
        System.out.println(ss.solve(list));
    }
}
