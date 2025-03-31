package LeetCode.hard;

import java.util.Arrays;

public class PutMarbleInBags {
    public static void main(String[] args) {
        PutMarbleInBags ob = new PutMarbleInBags();
        final long res = ob.putMarbles(new int[]{1, 3, 5, 1}, 2);
        System.out.println("res " + res);
    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] sum = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            sum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(sum);
        long minScore = 0, maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += sum[i];
            maxScore += sum[n - 2 - i];
        }
        return maxScore - minScore;
    }
}

// https://leetcode.com/problems/put-marbles-in-bags/
