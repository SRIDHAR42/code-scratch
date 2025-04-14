package LeetCode.medium;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean zR = false, zC = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zR = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                zC = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (zC) for (int c = 0; c < n; c++) matrix[0][c] = 0;
        if (zR) for (int r = 0; r < m; r++) matrix[r][0] = 0;
    }
}
//    https://leetcode.com/problems/set-matrix-zeroes/description/



