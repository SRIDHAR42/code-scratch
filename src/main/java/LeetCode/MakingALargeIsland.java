package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MakingALargeIsland {

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, Integer> islandSize = new HashMap<>();
        islandSize.put(0, 0);
        Queue<int[]> bfs = new LinkedList<>();

        int color = 1;
        int res = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    color++; // new color
                    bfs.add(new int[]{i, j});
                    int count = doParse(grid, bfs, color);
                    islandSize.put(color, count);
                    res = Math.max(res, count);
                }
            }
        }


        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> colors = new HashSet<>();
                    for (int[] dir : dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            colors.add(grid[r][c]);
                        }

                    }
                    int maxSize = 1;
                    for (Integer temp : colors) {
                        maxSize += islandSize.get(temp);
                    }
                    res = Math.max(res, maxSize);
                }
            }
        }

        return res;

    }

    private int doParse(int[][] grid, Queue<int[]> bfs, int color) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!bfs.isEmpty()) {
            int[] entry = bfs.poll();
            if (grid[entry[0]][entry[1]] != 1) {
                continue;
            }
            grid[entry[0]][entry[1]] = color;
            count++;
            for (int[] dir : dirs) {
                int r = entry[0] + dir[0];
                int c = entry[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    bfs.add(new int[]{r, c});
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MakingALargeIsland obj = new MakingALargeIsland();
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        final int res = obj.largestIsland(grid);
        System.out.println("result: " + res);
    }
}
