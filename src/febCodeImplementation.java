import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class febCodeImplementation {


    public int increasingSubsequence(int[] array) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            int max = 1;
            int temp = array[i];
            for(int j = i + 1; j < array.length; j++) {
                if(temp <= array[j]) {
                    temp = array[j];
                    max++;
                }
            }
            hmap.put(i, max);
        }
        int max = 0;
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            max = Math.max((int)pair.getValue(), max);
        }
        return max;
    }


    public int getClosestBinaryNode(BSTNode root, int target, int min, BSTNode temp) {
        if(root == null) {
            return -1;
        }
        int diff = Math.abs(target - root.data);
        if(diff < min) {
            min = diff;
            temp.data = root.data;
        }
        if(target < root.data) {
            getClosestBinaryNode(root.leftChild, target, min, temp);
        }else if(target > root.data) {
            getClosestBinaryNode(root.rightChild, target, min, temp);
        }
        return temp.data;
    }

    public int getClosestBinaryNodeHard(BSTNode root, int target, int min, BSTNode temp) {
        BSTNode minNode = new BSTNode(getClosestBinaryNode(root, target, Integer.MAX_VALUE, new BSTNode(Integer.MAX_VALUE)));
        return 1;
    }


    public int mindifferenceFast(BSTNode root) {
        if(root == null) {
            return -1;
        }

        return 1;
    }



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

    //
    public int maxSubArraySumLengthFast(int[] array, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(sum == k) {
                max = Math.max(max, i + 1);
            }

            int diff = sum - k;
            if(hmap.containsKey(diff)) {
                max = Math.max(max, i - hmap.get(diff));
            }
            if(!hmap.containsKey(sum)) {
                hmap.put(sum, i);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        febCodeImplementation ls = new febCodeImplementation();
        BSTNode  root = new BSTNode(9);
        root.leftChild    = new BSTNode(4);
        root.rightChild   = new BSTNode(17);
        root.leftChild.leftChild = new BSTNode(3);
        root.leftChild.rightChild = new BSTNode(6);
        root.leftChild.rightChild.leftChild = new BSTNode(5);
        root.leftChild.rightChild.rightChild = new BSTNode(7);
        root.rightChild.rightChild = new BSTNode(22);
        root.rightChild.rightChild.leftChild = new BSTNode(20);
        BSTNode temp = new BSTNode(Integer.MAX_VALUE);
        System.out.println(ls.mindifferenceFast(root)) ;
    }
}
