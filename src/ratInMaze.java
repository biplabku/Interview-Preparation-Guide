import java.util.Arrays;
import java.util.Stack;

public class ratInMaze {


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


    public static void main(String[] args) {
        int[][] arr ={
                {0,0,1},
                {1,0,1},
                {1,0,0},
        };
        ratInMaze ms = new ratInMaze();
        System.out.println(ms.findAPath(arr, 0,0));
    }
}
