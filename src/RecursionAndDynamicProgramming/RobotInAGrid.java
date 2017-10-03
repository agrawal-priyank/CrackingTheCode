package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class RobotInAGrid {

    public ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0){
            return null;
        }
        ArrayList<Point> path = new ArrayList<Point>();
        if(pathExists(maze, maze.length - 1, maze[0].length - 1, path)){
            return path;
        }
        return null;
    }

    private boolean pathExists(boolean[][] maze, int row, int col, ArrayList<Point> path){
        if(row < 0 || col < 0 || !maze[row][col]){
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        if(isAtOrigin || pathExists(maze, row - 1, col, path) || pathExists(maze, row, col - 1, path)){
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

}