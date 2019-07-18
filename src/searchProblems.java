import java.util.*;

public class searchProblems {

    public int wordLadder(List<String> list, String beginWord, String endWord) {
        if(list == null || list.size() == 0 || endWord.length() == 0 || beginWord.length() == 0 || beginWord == null || endWord == null) {
            return 0;
        }
        HashSet<String> wordSet = new HashSet<>(list);
        if(!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return res + 1;
                }
                for(int  i = 0; i < word.length(); i++) {
                    char[] newWord = word.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        newWord[i] = ch;
                        String str = new String(newWord);
                        if(!str.equals(word) && wordSet.contains(str)) {
                            queue.offer(str);
                            wordSet.remove(str);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

    public boolean isOneDiff(String beginWord, String endWord) {
        int count = 0;
        for(int  i = 0; i < beginWord.length(); i++) {
            if(beginWord.charAt(i) != endWord.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public boolean searchWord(char[][] grid, String word) {
        if(grid.length == 0 || grid == null || word == null || word.length() == 0) {
            return false;
        }

        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                char ch = grid[i][j];
                if(ch == word.charAt(0) && dfs(grid, word,0, i, j, grid.length, grid[0].length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, String word,int index, int r, int c, int row, int col) {
        if(word.length() == index) {
            return true;
        }
        char ch = word.charAt(index);
        if(ch == grid[r][c]) {
            char temp = grid[r][c];
            grid[r][c] = '*';
            if(checkMove(r + 1, c, row, col) && dfs(grid, word, index + 1, r + 1, c, row, col)
            || checkMove(r - 1, c, row, col) && dfs(grid, word, index + 1, r - 1, c, row, col)
            || checkMove(r, c + 1, row, col) && dfs(grid, word, index + 1, r, c + 1, row, col)
            || checkMove(r, c - 1, row, col) && dfs(grid, word, index + 1, r, c - 1, row, col)) {
                return true;
            }else {
                grid[r][c] = temp;
            }
        }

        return false;
    }

    public boolean checkMove(int row, int col, int r, int c) {
        return (r < 0 || r >= row || c < 0 || c >= col);
    }

    public int[][] fillMatrix(int[][] array) {
        boolean  isColumn = false;

        for(int i =0; i < array.length; i++) {
            if(array[i][0] == 0) {
                isColumn = true;
            }
            for(int j = 1; j < array[0].length; j++) {
                if(array[i][j] == 0) {
                    array[i][0] = 0;
                    array[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < array.length; i++) {
            for(int j = 1; j < array[0].length; j++) {
                if(array[i][0] == 0 || array[0][j] == 0) {
                    array[i][j] = 0;
                }
            }
        }

        if(array[0][0] == 0) {
            for(int j = 0; j < array[0].length; j++) {
                array[0][j] = 0;
            }
        }

        if(isColumn) {
            for(int j = 0; j < array.length; j++) {
                array[j][0] = 0;
            }
        }


        return array;

    }


    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        int a, b, c;
        a = b = c = 0;
        for(int i = 0; i< D; i++) {
            int tempA = result.get(a) * A;
            int tempB = result.get(b) * B;
            int tempC = result.get(c) * C;

            int min = tempA;
            min = Math.min(min, tempB);
            min = Math.min(min, tempC);

            result.add(min);

            if(min == tempA) {
                a++;
            }
            if(min == tempB) {
                b++;
            }
            if(min == tempC) {
                c++;
            }
        }
        result.remove(0);
        return result;
    }

    StringBuilder shortString;

    public String minWindows(String str, String pattern) {
        HashMap<Character, Integer> origMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            origMap.put(pattern.charAt(i), origMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while(start < str.length()) {
            HashMap<Character, Integer> currMap = new HashMap<>(origMap);
            int end = start;
            while(end < str.length() && !currMap.isEmpty()) {
                if(currMap.containsKey(str.charAt(end))) {
                    if(currMap.get(str.charAt(end)) == 1) {
                        currMap.remove(str.charAt(end));
                    }else {
                        currMap.put(str.charAt(end), currMap.get(str.charAt(end) - 1));
                    }
                }
                end++;
            }
            if(currMap.isEmpty() && (end - start) < min) {
                min = end - start;
                res = str.substring(start, end);
            }
            start++;
        }
        return res;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> goal = new HashMap<>();
        int goalSize = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        //target dictionary
        for(int k=0; k<t.length(); k++){
            goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
        }

        int i=0;
        int total=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(!goal.containsKey(c)){
                continue;
            }

            //if c is a target character in the goal, and count is < goal, increase the total
            int count = map.getOrDefault(c, 0);
            if(count<goal.get(c)){
                total++;
            }

            map.put(c, count+1);

            //when total reaches the goal, trim from left until no more chars can be trimmed.
            if(total==goalSize){
                while(!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i))>goal.get(s.charAt(i))){
                    char pc = s.charAt(i);
                    if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                        map.put(pc, map.get(pc)-1);
                    }

                    i++;
                }

                if(minLen>j-i+1){
                    minLen = j-i+1;
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;
    }


    public int search(final List<Integer> list, int b) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(b == list.get(mid)) {
                return low;
            }
            if(list.get(mid) >= list.get(low)) {
                if(b >= list.get(low) && b < list.get(mid)){
                    high =  mid - 1;
                }else {
                    low = mid + 1;
                }
            }else if(list.get(mid) < list.get(low)){
                if(b <= list.get(high) && b > list.get(mid)) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        searchProblems ss = new searchProblems();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        int[] arr = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202,
                203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37,
                38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83,
                85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116,
                118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152,
                155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177 };
        List<Integer> l = new ArrayList<>();
        for(int in: arr) {
            l.add(in);
        }
        System.out.println(ss.search(l,202));
    }
}
