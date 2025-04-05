package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillMatrix {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int origColor = image[sr][sc];
        if (origColor == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            image[r][c] = color;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == origColor) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}

// https://leetcode.com/problems/flood-fill/description/
