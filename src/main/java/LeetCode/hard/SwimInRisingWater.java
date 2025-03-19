package LeetCode.hard;

import java.util.*;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int l = 1, h = grid[0][0];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                h = Math.max(h, grid[i][j]);
            }
        }

        // res def = max time
        int res = h, midTime = 0;
        while (l <= h) {
            midTime = (l + h) / 2;
            if (possibleToReach(grid, midTime)) {
                // possible in midTime check if can do faster.
                res = Math.min(res, midTime);
                h = midTime - 1;
            } else {
                // not possible in midTime need more time
                l = midTime + 1;
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean possibleToReach(int[][] grid, int midTime) {
        int r = grid.length, c = grid[0].length;
        if (grid[r - 1][c - 1] > midTime) return false;
        if (grid[0][0] > midTime) return false;
        Stack<int[]> dfs = new Stack<>();
        boolean[][] visited = new boolean[r][c];
        if (grid[0][0] <= midTime) {
            dfs.add(new int[]{0, 0});
        }
        while (!dfs.isEmpty()) {
            int[] idx = dfs.pop();
            if (valid(idx, r, c)) {
                if (grid[idx[0]][idx[1]] > midTime) continue; // elevation within mid time
                // exec comes here when elev is <= midTime i.e we can reach
                if (idx[0] == r - 1 && idx[1] == c - 1) {
                    return true; // check if reached end
                }
                visited[idx[0]][idx[1]] = true;
                for (int[] dir : dirs) {
                    int[] neighbour = new int[]{idx[0] + dir[0], idx[1] + dir[1]};
                    if (valid(neighbour, r, c)
                            && !visited[neighbour[0]][neighbour[1]]
                            && grid[neighbour[0]][neighbour[1]] <= midTime) {
                        dfs.push(neighbour);
                    }
                }
            }
        }
        return false;
    }

    private boolean valid(int[] idx, int r, int c) {
        return idx[0] >= 0 && idx[0] < r && idx[1] >= 0 && idx[1] < c;
    }

    public static void main(String[] args) {
        SwimInRisingWater ob = new SwimInRisingWater();
        final int res = ob.swimInWater(new int[][]{{6, 22, 3, 23, 1},
                {14, 8, 7, 16, 5},
                {11, 0, 9, 15, 18},
                {24, 4, 2, 13, 19},
                {20, 10, 17, 21, 12}});
        System.out.println("res " + res);
    }

}

// https://leetcode.com/problems/swim-in-rising-water/description
