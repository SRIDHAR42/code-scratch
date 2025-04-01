package LeetCode.medium;

public class SolvingQuesWithBrainPower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brain = questions[i][1];
            int next = i + brain + 1;

            long current = points + (next < n ? dp[next] : 0);
            long skip = dp[i + 1];

            dp[i] = Math.max(current, skip);
        }
        return dp[0];
    }
}

// https://leetcode.com/problems/solving-questions-with-brainpower/
