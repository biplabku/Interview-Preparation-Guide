import java.util.*;

public class DailyCodingProblem {
    List<Integer> list;
    int count = 0;
    public DailyCodingProblem() {
        list = new ArrayList<>();
    }
    public int numberOfArithematicSlices(int[] array) {
        int res = 0;
        for(int i = 0; i < array.length - 2; i++) {
            int diff = array[i + 1] - array[i];
            for(int j = i + 2; j < array.length - 2; j++) {
                if(array[j] - array[j - 1] == diff) {
                    res++;
                }else {
                    break;
                }

            }
        }
        return res;
    }



    public boolean problem1(int[] array, int target) {
        HashSet<Integer> hset  = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if(!hset.contains(diff)) {
                hset.add(array[i]);
            }else {
                return true;
            }
        }
        return false;
    }


    public boolean problem1Method2(int[] array, int k) {
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            int target = k - array[i];
            int j = binarySearch(array, target, 0, array.length, i);
            if(j != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] array, int target, int start, int end, int index) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(array[mid] == target && mid != index) {
                return mid;
            }else if(array[mid] > target) {
                start = mid + 1;
                binarySearch(array, target, start, end, index);
            }else if(array[mid] < target) {
                end = mid - 1;
                binarySearch(array, target, start, end, index);
            }
        }
        return -1;
    }

    int[] newArray;
    // this is still O(N2) implementation
    public void multiplyEach(int[] array) {
        newArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            doMultiply(array, i - 1, i + 1, i);
        }
        for(int i = 0; i < array.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public void doMultiply(int[] array, int left, int right, int index) {
        int leftMul = 1;
        int rightMul = 1;
        while(left >= 0) {
            leftMul = leftMul * array[left];
            left--;
        }

        while(right < array.length) {
            rightMul = rightMul * array[right];
            right++;
        }
        newArray[index] = leftMul * rightMul;
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int temp = 1;
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                result[i] = 1;
            }else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        for(int i = size - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * nums[i];
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public int maxProductSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 1;
            for(int j = i; j < nums.length; j++) {
                sum = sum * nums[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxProductMethod2(int[] nums) {
        int maxProduct2 = nums[0] * nums[1];
        int maxProduct3 = maxProduct2 * nums[2];
        int res = 0;
        for(int i = 2; i < nums.length; i++) {
            int prod2 = nums[i - 1] * nums[i - 2];
            int prod3 = prod2 * nums[i];
            maxProduct2 = Math.max(maxProduct2, prod2);
            maxProduct3 = Math.max(maxProduct3, prod3);
            res = Math.max(maxProduct2, maxProduct3);
        }
        return res;
    }


    public boolean nQueenProblem(int number) {
        int[][] board = new int[number][number];
        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                board[i][j] = 0;
            }
        }

        if(solveNQueens(board, 0) == false) {
            return false;
        }
        return true;
    }

    public boolean solveNQueens(int[][] board, int col ) {
        if(col >= board.length) {
            return true;
        }

        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;
                if(solveNQueens(board, col + 1) == true) {
                    return true;
                }
                board[i][col] = 0; //  this is the most important step of backtracking
            }
        }
        return false;
    }

    public boolean isSafe(int[][] board, int col, int row) {
        int i;
        int j;
        for(i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return  false;
            }
        }

        for(i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean isStringMatch(String str, String pattern) {
        if(str.length() == 0 || pattern.length() == 0 || pattern == null || str == null) {
            return false;
        }
        str = str.toLowerCase();
        pattern = pattern.toLowerCase();

        int count1 = 0;
        int count2 = 0;
        char ch = str.charAt(count1);
        while(count2 < pattern.length() && count1 < str.length()) {
            if(pattern.charAt(count2) == '.' && pattern.charAt(count2 + 1) == '*') {
                if(count2 + 1 < pattern.length() )
                count1++;
                count2 = count2 + 1;
                count2++;
                break;
            }else if(pattern.charAt(count2) == '.' && pattern.charAt(count2 + 1) != '*') {
                count2++;
                count1++;
                break;
            }else if(pattern.charAt(count2) != '.' && pattern.charAt(count2) == '*' ) {
                count1++;
                break;
            }else if(pattern.charAt(count2) == ch && pattern.charAt(count2 + 1) != '*'){
                count1++;
                count2++;
                break;
            }else if(ch != pattern.charAt(count2) && pattern.charAt(count2 + 1) != '*') {
                return false;
            }else if(pattern.charAt(count2) != ch && pattern.charAt(count2 + 1) == '*') {
                count1++;
                count2 = count2 + 1;
                count2++;
                break;
            }
        }
        return true;

    }

    public void generateRandNumbers(int k) {
        Random rand = new Random();
        int[] array = new int[52];
        for(int i = 0; i < 52; i++) {
            array[i] = i;
        }
        // shuffle the cards based on the random function generator
        for(int i = 0; i < array.length; i++) {
            int random = i + rand.nextInt(52 - i);
            int temp = array[random];
            array[random] = array[i];
            array[i] = temp;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        if(!wordList.contains(endWord)) {
            return null;
        }
        wordList.add(0, beginWord);
        List<List<String>> result = new ArrayList<>();
        for(int i =0; i < wordList.size(); i++) {
            beginWord = wordList.get(i);
            for(int j = i + 1; j < wordList.size(); j++) {
                String value = wordList.get(j);
                if(compare2Strings(beginWord, value)) {
                    List<String> temp ;
                    if(!hmap.containsKey(beginWord)) {
                        temp = new ArrayList<>();
                        temp.add(value);
                        hmap.put(beginWord, temp);
                    }else {
                        temp = hmap.get(beginWord) ;
                        temp.add(value);
                        hmap.put(beginWord, temp);
                    }
                }
            }
        }
        // now i have to read the map to get the shortest path
        beginWord = wordList.get(0);
        for(int i = 1; i < wordList.size(); i++) {
            if(hmap.containsKey(beginWord)) {
                List<String> temp = hmap.get(beginWord);
            }
        }
        return result;
    }


    public boolean compare2Strings(String beginWord, String compareWord) {
        int count = 0;
        for(int i = 0; i < beginWord.length(); i++) {
            char ch1 = beginWord.charAt(i);
            char ch2 = compareWord.charAt(i);
            if(ch1 != ch2) {
                count++;
            }
        }
        return count <= 1? true:false;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    public List<String> word_Break(String s, List<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(List<Integer> list, int target) {
        combineSum(list, 0, target);
        return result;
    }

    public void combineSum(List<Integer> list, int start, int target) {
        if(target == 0 && !result.contains(temp)) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < list.size(); i++) {
            temp.add(list.get(i));
            combineSum(list, i, target - list.get(i));
            temp.remove(temp.size() - 1);
        }
    }


    public int ladderToLength(String start, String end, List<String> dict) {
        if(start.equals(end)) {
            return 1;
        }

        boolean[] visited = new boolean[dict.size()];
        Pair p = new Pair(start, 1);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        while(!queue.isEmpty()) {
            String cur = queue.peek().word;
            int len = queue.poll().length;
            int index = 0;

            for(String s : dict) {
                if(visited[index] == false && compare2Strings(cur, s)) {
                    Pair pnew = new Pair(s, len + 1);
                    queue.add(pnew);
                    visited[index] = true;
                    if(s.equals(end)) {
                        return len + 1;
                    }
                }
                index++;
            }
        }
        return 0;
    }

    class Pair{
        String word;
        int length;

        public Pair(String w, int i) {
            word = w;
            length = i;
        }
    }

    // 4,5,6,7,0,1,2
    // 3
    public int search(int[] array, int target) {
        return searchSortedArray(array, target, 0,array.length - 1);
    }

    public int searchSortedArray(int[] array, int target, int left, int right) {
        while(left <= right) {
            int mid = (left + right)/2;
            if(array[mid] == target) {
                return mid;
            }
            if(array[mid] > array[right]) {
                if(target > array[mid] || target <= array[right]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }else if(array[mid] < array[left]) {
                if(target > array[mid] && target <= array[right]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }else if(array[mid] == array[left]) {
                left++;
            }else if(array[mid] == array[right]) {
                right--;
            }
            if(left == right && target != array[left]) {
                return -1;
            }
        }
        return -1;
    }


    public int uniquePaths(int[][] obstacleGrid) {
        // it starts from 0,0 to  the bottom right corner
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) {
                obstacleGrid[0][i] = 1;
            }else {
                obstacleGrid[0][i] = 0;
            }
        }

        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }
        }
        for(int i = 1;i < obstacleGrid.length; i++) {
            for(int j = 1; j <obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid.length - 1];
    }


    public int calculate(int[][] grid, int i, int j) {
        if(i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for(int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return  queue.poll();
    }


    public boolean insert(int val){
        if(!list.contains(val)) {
            list.add(val);
            count++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(list.contains(val)) {
            list.remove(val);
            count--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        if(count <= 0) {
            return -1;
        }
        Random rand = new Random();
        int randint = rand.nextInt(count);
        while(!list.contains(randint)) {
            randint = rand.nextInt(count);
        }
        return list.get(randint);
    }



    public void swap2(int number1, int number2) {
        System.out.println(number1 + " - " + number2);
        number1 = number2  + number1;
        number2 = number1 - number2;
        number1 = number1 - number2;
        System.out.println(number1 + " - " + number2);
    }



    public boolean searchWord(char[][] grid, String str) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(dfs(grid, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, String str, int row, int col, int count) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return false;
        }
        if(grid[row][col] == str.charAt(count)) {
            char temp = grid[row][col];
            grid[row][col] = '*';
            if(count == str.length() - 1) {
                return true;
            }else if(dfs(grid, str, row, col + 1, count+1) ||
            dfs(grid, str, row, col - 1, count + 1) ||
            dfs(grid, str,row + 1,col, count + 1) ||
            dfs(grid, str, row - 1,col, count  +1)) {
                return true;
            }
            grid[row][col] = temp;
        }

        return false;
    }

    // {2,0,2,1,1,0, 4,9,8,9,8,4};
    public void sortInPlace(int[] array) {
        int count = 1;
        int index = 0;
        while (index < array.length && count < array.length){
            if(array[index] == array[count] && index + 1 == count) {
                index = count + 1;
                count = index + 1;
            }else if(array[index] != array[count]){
                count++;
            }else if(array[index] == array[count] && index + 1 != count) {
                int temp = array[index + 1];
                array[index + 1] = array[count];
                array[count] = temp;
                index = index + 2;
                count = index + 1;
            }
        }
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public void sortColors(int[] array) {
        int index = 0;
        int index1 = 0;
        int index2 = array.length - 1;
        while(index <= index2) {
            if(array[index] == 0) {
                swap(array, index1, index);
                index1++;
                index++;
            }else if(array[index] == 2) {
                swap(array, index2, index);
                index2--;
            }else {
                index++;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



















    public static void main(String[] args) {
        DailyCodingProblem ds = new DailyCodingProblem();
        int[] array = {2,0,2,1,1,0};
        String str1 = "hit";
        String str2 = "cog";
        List<String> t = new ArrayList<>();
        t.add("hot");
        t.add("dot");
        t.add("dog");
        t.add("lot");
        t.add("log");
        t.add("cog");
        char[][] grid = {{'a','x','m','y'},{'b','g','d','f'},
                {'x','e','e','t'},{'r','a','k','s'}};
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);
        temp.add(5);
        temp.add(7);
        /*
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(ds.insert(1));
        System.out.println(ds.remove(2));
        System.out.println(ds.insert(2));
        System.out.println(ds.getRandom());
        System.out.println(ds.remove(1));
        System.out.println(ds.insert(2));
        System.out.println(ds.getRandom());
        */

        ds.sortColors(array);
    }
}
