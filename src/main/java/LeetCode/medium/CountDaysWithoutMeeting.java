package LeetCode.medium;

import java.util.*;

public class CountDaysWithoutMeeting {
    public int countDays(int days, int[][] meetings) {
        int res = 0;
        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });
        int lastMeet = 0, s, e;
        for (int i = 0; i < meetings.length; i++) {
            s = meetings[i][0];
            e = meetings[i][1];
            if (lastMeet < s) {
                res += s - lastMeet - 1;
                // System.out.println("res " + res);
            }
            lastMeet = Math.max(lastMeet, e);
        }
        if (days > lastMeet) res += days - lastMeet;
        return res;
    }
}
// https://leetcode.com/problems/count-days-without-meetings/description/