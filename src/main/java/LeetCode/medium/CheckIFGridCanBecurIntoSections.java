package LeetCode.medium;

import java.util.Arrays;

public class CheckIFGridCanBecurIntoSections {

    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (rectangles.length <= 1) return true;
        int[] rect;
        Arrays.sort(rectangles, (a, b) -> {
            return a[0] - b[0];
        });
        //  for horizontal we have index 0, 2
        int count = 1, x = rectangles[0][0], y = rectangles[0][2];
        for (int i = 1; i < rectangles.length; i++) {
            int start = rectangles[i][0], end = rectangles[i][2];
            if (start >= y) {
                count++; // no overlap 1 cut
            }
            if (count >= 3) return true;
            x = Math.min(x, start);
            y = Math.max(y, end);
        }

        Arrays.sort(rectangles, (a, b) -> {
            return a[1] - b[1];
        });
        //  for horizontal we have index 1, 3
        count = 1;
        x = rectangles[0][1];
        y = rectangles[0][3];
        for (int i = 1; i < rectangles.length; i++) {
            int start = rectangles[i][1], end = rectangles[i][3];
            if (start >= y) {
                count++; // no overlap 1 cut
            }
            if (count >= 3) return true;
            x = Math.min(x, start);
            y = Math.max(y, end);
        }

        return false;
    }
}

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/
