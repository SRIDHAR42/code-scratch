package LeetCode.medium;

import java.util.Arrays;

public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> {
            return a[1] - b[1];
        });

        int[] curr = intervals[0];
        int max = 1;
        int a = curr[0],b = curr[1],c,d;
        for (int i = 1; i < n; i++) {
            c = intervals[i][0];
            d = intervals[i][1];
            if (c < b) {
                continue;
            }
            b = Math.max(b, d);
            max++;
        }
        return n - max;
    }

    public static void main(String[] args) {
        NonOverlappingInterval ob = new NonOverlappingInterval();
        int[][] intervals = new int[][]{{1,2}, {1,2}, {1,2}};
//        int[][] intervals = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};
        final int res = ob.eraseOverlapIntervals(intervals);
        System.out.println("res " + res);
    }
}

//https://leetcode.com/problems/non-overlapping-intervals/description/?envType=problem-list-v2&envId=plakya4j
// same as max meeting attended
