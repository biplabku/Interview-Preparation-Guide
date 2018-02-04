import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class robotINgrid {

    public static ArrayList<Point> getPath(boolean[][] maze) {
        if(maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        if(getPath(maze, maze[0].length, maze.length - 1, path)) {
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if(row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if(isAtOrigin || (getPath(maze, row - 1, col, path ) || (getPath(maze, row, col -1, path)))) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }


    public static ArrayList<Point> getPath1(boolean[][] maze) {
        if(maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if(getPath1(maze, maze[0].length, maze.length, path, failedPoints)) {
            return path;
        }
        return null;
    }

    public static boolean getPath1(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if(row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col) ;
        if(failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin  = (row == 0) && (col == 0);
        if((getPath1(maze, row - 1, col, path, failedPoints) || getPath1(maze, row, col -1, path, failedPoints) || isAtOrigin)){
            path.add(p);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] array = new boolean[5][5];
        getPath(array);
    }
}
