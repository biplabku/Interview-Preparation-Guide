public class ratInMaze {


    // Let say we first want to see if there is a path at all instead of finding a path to the goal
    public boolean findAPath(int[][] arr, int x, int y) {
        // breadth first search or depth first search
        // one of the methods can be used most probably for implementing this solution

        return false;
    }

    public 

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
