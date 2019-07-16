import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class srcToDestination {

    // str = hello
    // list = "he", "el",
    // if there is a match then start with break and end with a break and if there
    // is no match then save that character
    public String combineString(String str, List<String> dictionary) {
        StringBuilder sb = new StringBuilder();
        String openBr = "<br>";
        String closeBr = "</br>";

        ArrayList<Points> list = new ArrayList<>();

        for(int i = 0; i < dictionary.size(); i++) {
            String s = dictionary.get(i);
            int y = str.indexOf(s);
            if(y != -1) {
                Points p = new Points(y, y + s.length());
                list.add(p);
            }
        }

        // sort the elements based on the first occurence;
        Collections.sort(list, new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                return o1.x - o2.x;
            }
        });

        // how to merge them based on the sorted values
        sb.append(openBr);
        if(list.get(0).x == 0) {
            sb.append(str.substring(0, list.get(0).y));
        }else {
            sb.append(str.substring(0,list.get(0).x));
        }
        sb.append(closeBr);
        for(int i = 1; i < list.size(); i++) {
            Points prev = list.get(i - 1);
            Points next = list.get(i);
            if(prev.y  + 1 >= next.x) {
                String s = str.substring(next.x, next.y);
                sb.append(openBr);
                sb.append(s);
                sb.append(closeBr);
            }else {
                String s = str.substring(prev.y, next.x);
                sb.append(s);
                String s1 = str.substring(next.x, next.y);
                sb.append(openBr);
                sb.append(s1);
                sb.append(closeBr);
            }
        }
        if(list.get(list.size() -1).y != str.length()) {
            sb.append(str.substring(list.get(list.size() - 1).y));
        }
        return sb.toString();
    }

    class Points{
        int x;
        int y;
        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getTotalDistanceFromSourceToDestination (int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 0 means block
        // 1 means path
        boolean[][] visited = new boolean[rows][cols];
        int res = search(grid, visited, 0,0, Integer.MAX_VALUE, 0);
        return res;
    }

    public static int search(int[][] grid, boolean[][] visited, int row, int col, int minPath, int path) {
        if(grid[row][col] == 9) {
            return Integer.min(path, minPath);
        }
        visited[row][col] = true;
        if(isValidMove(grid, visited,row + 1, col) ) {
            minPath += search(grid, visited, row + 1, col, minPath, path + 1);
        }

        if(isValidMove(grid, visited,row - 1, col) ) {
            minPath += search(grid, visited, row - 1, col, minPath, path + 1);
        }

        if(isValidMove(grid, visited, row, col + 1)) {
            minPath += search(grid, visited, row, col + 1, minPath, path + 1);
        }

        if(isValidMove(grid, visited, row, col - 1) ) {
            minPath += search(grid, visited, row, col - 1, minPath, path + 1);
        }
        visited[row][col] = false;
        return minPath;
    }

    public static boolean isValidMove(int[][] grid, boolean[][] visited, int i, int j) {
        return (i >=0 && i < grid.length && j >= 0 && j < grid[0].length && (grid[i][j] == 1 ||
                grid[i][j] ==9) && visited[i][j] == false);

    }

    static class DNode{
        char c;
        HashMap<Character, DNode> children = new HashMap<>();
        boolean isEndOfWord = false;

        public DNode() {
        }

        public DNode(char ch) {
            c = ch;
        }
    }

    static DNode root;

    public srcToDestination() {
        root = new DNode();
    }

    public static boolean wordBreak(String str, List<String> wordDict) {
        HashMap<Character, DNode> childrens = root.children;
        for(int i = 0; i < wordDict.size(); i++) {
            String s = wordDict.get(i);
            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                DNode t;
                if(childrens.containsKey(ch)) {
                    t = childrens.get(ch);
                }else {
                    t = new DNode(ch);
                    childrens.put(ch, t);
                }
                childrens = t.children;
                if(i == s.length()-1){
                    t.isEndOfWord = true;
                }
            }
        }

        DNode child = null;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(childrens.containsKey(ch)) {
                child = childrens.get(ch);
                if(child.isEndOfWord == true) {
                    child = null;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public int atoi(String str) {
        str = str.trim();
        long result = 0;
        int sign = 1;
        int index = 0;
        if(str.length() == 0) {
            return 0;
        }
        if(str.charAt(0) == '+' || str.charAt(0) =='-') {
            sign = str.charAt(0) == 1? 1: -1;
        }
        for(int i = index;i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if(digit >= 0 && digit <= 9) {
                result = result * 10 + digit;
                if(result > Integer.MAX_VALUE) {
                    return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }

        }
        return (int)result * sign;
    }

    public boolean containsNearByAlmostDuplicates(int[] nums, int k, int t) {
        return false;
    }

    public void merge(int[] nums1, int[] nums2, int m, int n) {
        int[] res = new int[m + n];
        doMerge(res, 0, nums1, nums2, 0, 0);
        display(res);
    }

    public void display(int[] res) {
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public void doMerge(int[] res, int count, int[] nums1, int[] nums2, int m, int n) {
        if(count > res.length) {
            return ;
        }
        while(m < nums1.length && n < nums2.length) {
            if(nums1[m] >= nums2[n]) {
                res[count] = nums2[n];
                n++;
            }else {
                res[count] = nums1[m];
                m++;
            }
            count++;
        }
        while(n < nums1.length) {
            res[count] = nums2[n];
            n++;
            count++;
        }
        while(m < nums2.length){
            res[count] = nums1[m];
            m++;
            count++;
        }

    }

    // nums1 = {1,2,3,0,0,0}
    // nums2 = {2,5,6}
    // m = 3
    // n = 3
    public void doFastMerge(int[] nums1, int[] nums2, int m, int n) {
        int count1 = m - 1;
        int count2 = n - 1;

        int movingCounter = m + n - 1;

        while(count1 >= 0 && count2 >= 0) {
            nums1[movingCounter--] = nums1[count1] > nums2[count2] ? nums1[count1--]:nums2[count2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, count2 + 1);
        display(nums1);
    }

    public List<List<Integer>> intervalIntersection(int[][] a, int[][] b) {
        List<List<Integer>> result = new ArrayList<>();
        int j = 0;
        int i = 0;
        while(i < a.length && j < b.length) {
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            if(start <= end) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                result.add(temp);
            }

            if(a[i][1] < b[j][1]) {
                i++;
            }else {
                j++;
            }
        }
        return result;
    }

    public int compareVersion(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();

        String[] ar1 = str1.split("\\.");
        String[] ar2 = str2.split("\\.");

        int len = ar1.length > ar2.length ? ar1.length:ar2.length;
        for(int i = 0; i < len; i++) {
            // select value based on the length. if the array ends before the other then choose zero.
            int v1 = ar1.length > i ? Integer.valueOf(ar1[i]) : 0;
            int v2 = ar2.length > i ? Integer.valueOf(ar2[i]) : 0;
            if(v1 > v2) {
                return 1;
            }
            if(v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for(int i =0; i < s.length; i++) {
            int count = i;
            while(i < s.length && s[i] != ' ') {
                i++;
            }
            reverse(s, count, i-1);
        }
    }

    public void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        int[][] grid ={{ 1, 0, 1},
                        {1, 0, 1 },
                        {1, 1, 9 }};
        srcToDestination ss = new srcToDestination();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        String str = "appletagpena";
        int[] one = {2,5,6, 0, 0, 0};
        int[] two = {4,5,5};
        int[][] a = {{0,2},{5,10},{13,23},{24,25}};
        int[][] b = {{1,5},{8,12},{15,24},{25,26}};
        String str1 = "1.0";
        String str2 = "1.0";
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ss.reverseWords(s);

    }
}
