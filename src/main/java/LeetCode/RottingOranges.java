package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<List<Integer>> rotton = new HashSet<>();
        Set<List<Integer>> rottonNext = new HashSet<>();
        Set<List<Integer>> fresh = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // fresh
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    fresh.add(tmp);

                } else if (grid[i][j] == 2) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    rotton.add(tmp);
                }
            }
        }

        int cycle = Math.max(m, n) + 1;
        for (int time = 1; time <= cycle; time++) {
            // take each rotton orange check fresh range neighbour
            for (List<Integer> orange: rotton) {
                removeFromNeighbour(orange, rottonNext, fresh, m, n);
            }
            rotton = rottonNext;
            rottonNext = new HashSet<>();

            if (fresh.size() == 0) {
                return time;
            }
        }

        return 0;
    }

    public void removeFromNeighbour(List<Integer> orange,
                                    Set<List<Integer>> rottonNext,
                                    Set<List<Integer>> fresh,
                                    int m,  int n) {
        int x = orange.get(0);
        int y = orange.get(1);
        if (valid(x + 1, y, m , n)) {
            orange.set(0, x + 1);
            orange.set(1, y);
            if (fresh.contains(orange)) {
                rottonNext.add(new ArrayList<>(orange));
                fresh.remove(orange);
            }
        }

        if (valid(x - 1, y, m , n)) {
            orange.set(0, x - 1);
            orange.set(1, y);
            if (fresh.contains(orange)) {
                rottonNext.add(new ArrayList<>(orange));
                fresh.remove(orange);
            }
        }

        if (valid(x, y + 1, m ,n)) {
            orange.set(0, x);
            orange.set(1, y + 1);
            if (fresh.contains(orange)) {
                rottonNext.add(new ArrayList<>(orange));
                fresh.remove(orange);
            }
        }

        if (valid(x, y - 1, m ,n)) {
            orange.set(0, x);
            orange.set(1, y - 1);
            if (fresh.contains(orange)) {
                rottonNext.add(new ArrayList<>(orange));
                fresh.remove(orange);
            }
        }
    }

    public boolean valid(int x, int y, int  m , int n)  {
        return (x >= 0) && (x < m) && (y >=0) && (y < n);
    }

    // **********************************************************

    public int orangesRotting1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int []> rotton = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for ( int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotton.add(new int[]{i,j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 0;
        int [][] dirs = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh > 0 && !rotton.isEmpty() ) {
            time++;
            System.out.println("time " + time);
            int size = rotton.size();
            for (int i = 0; i < size; i++) {
                int[] orange = rotton.remove();
                for (int[] dir: dirs) {
                    int x = orange[0] + dir[0];
                    int y = orange[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        //neighbour fresh orange
                        grid[x][y] = 2;
                        rotton.add(new int[]{x,y});
                        fresh--;
                        System.out.println("x,y " + x + " " + y);
                    }
                }
            }
            System.out.println("fresh " + fresh);
        }

        return (fresh == 0) ? time : -1;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][] {
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1},
        };
        RottingOranges obj = new RottingOranges();
        final int time = obj.orangesRotting1(grid);
        System.out.println("time " + time);
    }
}

//https://leetcode.com/problems/rotting-oranges/?envType=problem-list-v2&envId=plakya4j

// medium