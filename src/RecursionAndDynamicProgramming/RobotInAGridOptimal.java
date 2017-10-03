package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotInAGridOptimal {

    public ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0){
            return null;
        }
        ArrayList<Point> path = new ArrayList<Point>();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
        if(pathExists(maze, maze.length - 1, maze[0].length - 1, path, cache)){
            return path;
        }
        return null;
    }

    private boolean pathExists(boolean[][] maze, int row, int col, ArrayList<Point> path,
                              HashMap<Point, Boolean> cache){
        if(row < 0 || col < 0 || !maze[row][col]){
            return false;
        }
        Point p = new Point(row, col);
        if(cache.containsKey(p)){
            return cache.get(p);
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        boolean success = false;
        if(isAtOrigin || pathExists(maze, row - 1, col, path, cache)
                      || pathExists(maze, row, col - 1, path, cache)){
            path.add(p);
            success = true;
        }
        cache.put(p, success);
        return success;
    }

}