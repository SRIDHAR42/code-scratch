package LeetCode;

import java.util.TreeMap;

public class MaxAreaIsland {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // not visited
                    res = Math.max(res, explore(grid, i, j));
                }
            }
        }
        return res;
    }

    public int explore(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = -1; // mark visited
        // System.out.println("visited " + i + " " + j);
        int area = 1;
        for (int[] dir : dirs) {
            area += explore(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}
