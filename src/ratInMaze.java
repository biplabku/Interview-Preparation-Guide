import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ratInMaze {

    public int N = 3;
    int[][] helper = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
    };

    public List<Interval> mergeIntervals(List<Interval> list) {
        List<Interval> result = new ArrayList<>();
        if(list.size() < 1) {
            return result;
        }
        // sort the input based on the first start times
        
        result.add(list.get(0));
        int counter = 0;
        for(int i = 1; i < list.size(); i++) {
            Interval temp = result.get(counter);
            Interval next = list.get(i);

            if(temp.endTime >= next.startTime) {
                result.set(counter, new Interval(temp.startTime, next.endTime));
            }else {
                result.add(next);
                counter++;
            }
        }
        for(int i =0; i < result.size(); i++) {
            System.out.println("[" + result.get(i).startTime + "," + result.get(i).endTime + "]");
        }
        return result;
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

        if(isValid(maze, x, y) == true) {
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


    // getting a binary representation of a number
    public int complementNumber(int number) {
        if(number == 0) {
            return 1;
        }else if(number == 1) {
            return 0;
        }
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        while(number > 1) {
            remainder = number %2;
            sb.append(remainder);
            number = number/2;

        }
        sb.append(number);
        String str = sb.reverse().toString();
        // invert the values of the string
        int result = 0;
        number = 0;
        for(int i = str.length() - 1; i >= 0; i-- ) {
            if(sb.charAt(i) == '0') {
                result = result + (int)Math.pow(2, number);
            }else if(sb.charAt(i) == '1') {
                result = result + 0 * (int)Math.pow(2, number);
            }
            number++;
        }
        return result;
    }

    public boolean isValid(int[][] maze, int x, int y) {
        return (x >=0 && x < N && y >= 0 && y < N && maze[x][y] == 0);

    }



    public boolean findPath(int[][] maze) {
        if(solveMaze(maze, 0, 0, helper) == true) {
            return true;
        }
        return false;
    }

    public boolean solveMaze(int[][] maze, int x, int y, int[][] statusBits) {
        if(x == N - 1 && y == N - 1) {
            statusBits[x][y] = 1;
            return true;
        }
        if(solve(maze, x, y, statusBits) == true) {
            statusBits[x][y] = 1;

            // now we have to check which direction it needs to move
            // move right
            if(solveMaze(maze, x, y + 1, statusBits)) {         // move right
                return true;
            }else if(solveMaze(maze, x, y - 1, statusBits)) {   // move left
                return true;
            }else if(solveMaze(maze, x + 1, y, statusBits)) {   // move up
                return true;
            }else if(solveMaze(maze, x - 1, y, statusBits)) {   // move down
                return true;
            }
            statusBits[x][y] = 0;
            return false;
        }
        return false;
    }

    public boolean solve(int[][] maze, int x, int y, int[][] statusBits) {
        if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr ={
                {1,1,1},
                {1,0,1},
                {1,0,1},
        };
        ratInMaze ms = new ratInMaze();
        // System.out.println(ms.findPath(arr));
        // System.out.println(ms.complementNumber(2));
        List<Interval> list = new ArrayList<>(Arrays.asList(new Interval(1,2), new Interval(2,6), new Interval(8,10), new Interval(11,15)));
        System.out.println(ms.mergeIntervals(list));
    }
}
