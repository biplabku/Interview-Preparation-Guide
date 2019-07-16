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
        System.out.println(ss.wordLadder(list, beginWord, endWord));
    }
}
