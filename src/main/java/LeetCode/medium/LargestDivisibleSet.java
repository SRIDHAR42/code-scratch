package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSet {
    public static void main(String[] args) {
        LargestDivisibleSet ob = new LargestDivisibleSet();
        final List<Integer> list = ob.largestDivisibleSubset(new int[]{3, 4, 16, 8});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1); // intitally all set of size 1 i.e itself
        Arrays.fill(prev, -1);

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    // should be divisible and size of subset should be smaller than new;
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) maxi = i;
        }

        // create res;
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; ) {
            res.add(0, nums[i]);
            i = prev[i];
        }

        return res;
    }


}
