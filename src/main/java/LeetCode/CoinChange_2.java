package LeetCode;

public class CoinChange_2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }


    // works but gives TLE
//    int res = 0;
//    public int change(int amount, int[] coins) {
//        res = 0;
//        helper(amount, coins, 0, 0);
//        return res;
//    }
//
//    private void helper(int amount, int[] coins, int idx, int sum) {
//        if (sum == amount) {
//            res++;
//            return;
//        }
//        if (idx >= coins.length || sum > amount) {
//            return;
//        }
//        helper(amount, coins, idx, sum + coins[idx]);
//        helper(amount, coins, idx + 1, sum);
//    }

    public static void main(String[] args) {
        CoinChange_2 obj = new CoinChange_2();
        final int change = obj.change(500, new int[]{3, 5, 7, 8, 9, 10, 11});
        System.out.println("change: " + change);
    }

} // medium

// https://leetcode.com/problems/coin-change-ii/description/?envType=problem-list-v2&envId=plakya4j
