package LeetCode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxPointGridQuery {
    boolean[][] visited;
    int[][] grid;

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        MaxPointGridQuery ob = new MaxPointGridQuery();
        final int[] ints = ob.maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2});
        System.out.println(ints);
    }

    public int[] maxPoints(int[][] grid, int[] queries) {


        this.grid = grid;
        List<int[]> qList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            qList.add(new int[]{queries[i], i});
        }
        Collections.sort(qList, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        int[] res = new int[queries.length];
        int point = 0;
        visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        //        add grid[0][0], row = 0, col = 0
        pq.add(new int[]{grid[0][0], 0, 0});

        for (int i = 0; i < qList.size(); i++) {
            int maxVal = qList.get(i)[0], idx = qList.get(i)[1];

            while (!pq.isEmpty() && pq.peek()[0] < maxVal) {
                int[] peEle = pq.poll();
                int r = peEle[1], c = peEle[2];
                point++;
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (valid(nr, nc) && !visited[nr][nc]) {
                        pq.add(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            res[idx] = point;
        }
        return res;
    }

    private boolean valid(int r, int c) {
        return (r >= 0) && (r < grid.length) && (c >= 0) && (c < grid[0].length);
    }


}

// https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/
