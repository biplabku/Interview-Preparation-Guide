public class srcToDestination {

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
        return (i >=0 && i < grid.length && j >= 0 && j < grid[0].length && (grid[i][j] == 1 || grid[i][j] ==9) && visited[i][j] == false);

    }

    public static void main(String[] args) {
        int[][] grid ={{ 1, 0, 1},
                        {1, 0, 1 },
                        {1, 1, 9 }};
        System.out.println(getTotalDistanceFromSourceToDestination(grid));
    }
}
