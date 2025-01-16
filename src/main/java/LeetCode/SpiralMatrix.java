package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    int [][] matrix;
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[] dirs = {0,1,2,3}; // 0 right; 1 down; 2 left; 3 up
        int[] idx = new int[2];
        int dir = dirs[0];
        while (res.size() < (m*n)) {
            int x = idx[0], y = idx[1];
            System.out.println("x: " + x + " y: " + y);
            res.add(matrix[x][y]);
            matrix[x][y] = -101;
            dir = getNextValid(idx, dir);
        }
        return res;
    }

    // updates the idx and returns current direction
    private int getNextValid(int[] idx, int dir) {
        int[] newIdx = new int[]{idx[0], idx[1]};
        update(newIdx, dir);
        if (valid(newIdx)) {
            idx[0] = newIdx[0];
            idx[1] = newIdx[1];
            return dir;
        }

        update(idx, (dir +1 ) % 4);
        return (dir + 1) % 4;
    }

    private void update(int[] idx, int dir) {
        switch(dir){
            case 0: {
                idx[1] = idx[1] + 1;
                break;
            }
            case 1: {
                idx[0] = idx[0] + 1;
                break;
            }
            case 2: {
                idx[1] = idx[1] - 1;
                break;
            }
            case 3: {
                idx[0] = idx[0] - 1;
                break;
            }
            default: {
                break;
            }
        }
    }

    private boolean valid(int[] idx) {
        return (idx[0] >= 0) && (idx[0] < matrix.length) &&
                (idx[1] >= 0) && (idx[1] < matrix[0].length) &&
                (matrix[idx[0]][idx[1]] != -101);
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int d = 0;
        while (top <= down && left <= right) {
            if (d == 0) { // right;
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            } else if (d == 1) { // down
                for (int i = top; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;

            } else if (d == 2) { // left
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;

            } else { // top
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

            d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        final List<Integer> integerList = obj.spiralOrder(new int[][]{
                {2,5}, {8, 4}, {0, -1}
        });
        System.out.println(" res " + integerList);
    }
}
