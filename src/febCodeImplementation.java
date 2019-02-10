import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class febCodeImplementation {


    public int minDistance(String word1, String word2) {
        int res = 0;
        TreeMap<Character, Integer> tmap1 = new TreeMap<>();
        TreeMap<Character, Integer> tmap2 = new TreeMap<>();
        for(int i = 0 ; i < word1.length(); i++) {
            if(!tmap1.containsKey(word1.charAt(i))) {
                tmap1.put(word1.charAt(i), 1);
            }else{
                tmap1.put(word1.charAt(i), tmap1.get(word1.charAt(i)) + 1);
            }
        }
        for(int i = 0 ; i < word2.length(); i++) {
            if(!tmap2.containsKey(word2.charAt(i))) {
                tmap2.put(word2.charAt(i), 1);
            }else{
                tmap2.put(word2.charAt(i), tmap2.get(word2.charAt(i)) + 1);
            }
        }
        // res = Math.abs(tmap1.size() - tmap2.size());

        Iterator iter1= tmap1.entrySet().iterator();
        Iterator iter2 = tmap2.entrySet().iterator();

        while(iter1.hasNext() && iter2.hasNext()) {
            Map.Entry pair1 = (Map.Entry)iter1.next();
            Map.Entry pair2 = (Map.Entry)iter2.next();
            char ch1 = (char)pair1.getKey();
            char ch2 = (char)pair2.getKey();
            if(tmap2.containsKey(ch1)) {
               tmap1.put(ch1, tmap1.get(ch1) - 1);
               tmap2.put(ch2, tmap2.get(ch2) - 1);
               if(tmap2.get(ch2) < 0) {
                   res += 1;
               }
            }else{
                res += 1;
            }
        }
        return res;
    }

    // [1, -1, 5, -2, 3] and k = 3
    public int maxSubArraySum(int[] array, int k) {
        int sum = 0;

        int max = 0;
        for(int i = 0; i < array.length; i++) {
            sum = array[i];
            for(int j = i + 1; j < array.length; j++) {
                sum +=  array[j];
                if(sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        febCodeImplementation ls = new febCodeImplementation();
        String str1 = "horse";
        String str2 = "ros";
        int[] array = {-2,-1,2,1};
        System.out.println(ls.maxSubArraySum(array, 1)) ;
    }
}
