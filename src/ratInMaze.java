import java.util.Arrays;
import java.util.Stack;

public class ratInMaze {

    public int N = 3;
    int[][] helper = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    // Let say we first want to see if there is a path at all instead of finding a path to the goal
    public boolean findAPath(int[][] arr, int x, int y) {
        // breadth first search or depth first search
        // one of the methods can be used most probably for implementing this solution
        boolean[][] isVisited = {
                {false, false, false},
                {false, false, false},
                {false, false, false},
        };

        Stack<rowColsNode> thestack = new Stack<>();
        rowColsNode node = new rowColsNode(0,0);
        thestack.push(node);

        isVisited[0][0] = true;
        while(!thestack.isEmpty()) {
            rowColsNode node1 = thestack.peek();
            rowColsNode temp = getAdjacent(node1, arr);
            if((temp.getRow() != -1 || temp.getCol() != -1)) {
                thestack.pop();
            } else {
                isVisited[temp.getRow()][temp.getCol()] = true;
                thestack.push(temp);
            }
        }
        return isVisited[arr.length][arr.length];
    }

    public rowColsNode getAdjacent(rowColsNode node, int[][] arr) {
        int row = node.getRow();
        int col = node.getCol();
        if(arr[row][col] == 0 ){
            return new rowColsNode(row,col);
        }
        return new rowColsNode(-1, -1);
    }

    public class rowColsNode {
        int row;
        int col;

        public rowColsNode(int r, int c) {
            row = r;
            col = c;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    // starts from point 0,0 and check whether there exists a path to n-1, n-1
    public boolean findRoute(int[][] maze) {

        boolean value = checkRoute(maze, 0, 0, helper);
        if(value == false) {
            return false;
        }
        return true;
    }

    public boolean checkRoute(int[][] maze, int x, int y, int[][] helper) {
        if(x == N-1 && y == N-1 ) {
            helper[x][y] = 1;
            return true;
        }

        if(isValid(maze, x, y)) {
            helper[x][y] = 1;

            // go down
            if(checkRoute(maze, x+1, y, helper)) {
                return true;
            }
            // go right
            if(checkRoute(maze, x, y+1, helper)) {
                return true;
            }
            // go up
            if(checkRoute(maze, x-1, y, helper )) {
                return true;
            }
            // go left
            if(checkRoute(maze, x, y-1, helper)) {
                return true;
            }
            helper[x][y] = 0;
            return false;
        }
        return false;
    }

    public boolean isValid(int[][] maze, int x, int y) {
        return (x >=0 && x < N && y >= 0 && y < N && maze[x][y] == 0);

    }


    public static void main(String[] args) {
        int[][] arr ={
                {0,0,1},
                {1,0,1},
                {1,0,1},
        };
        ratInMaze ms = new ratInMaze();
        System.out.println(ms.findRoute(arr));
    }
}
