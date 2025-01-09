package LeetCode;

public class MinCostClimbingStr {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) return 0;
        int f = cost[0];
        int s = cost[1];
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = cost[i] + Math.min(f, s);
            f = s;
            s = res;
        }
        System.out.println(Math.min(f, s));
        return Math.min(f, s);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
//        System.out.println(Math.min(dp[n-1],dp[n-2]));
        return Math.min(dp[n-1],dp[n-2]);
    } // O(n) time and O(n) space

    public static void main(String[] args) {
        MinCostClimbingStr obj = new MinCostClimbingStr();
        obj.minCostClimbingStairs(new int[]{10, 15, 20});
        obj.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

    }
}

// https://leetcode.com/problems/min-cost-climbing-stairs/?envType=problem-list-v2&envId=plakya4j
