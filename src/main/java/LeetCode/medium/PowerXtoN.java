package LeetCode.medium;

public class PowerXtoN {
    public double myPow(double x, int n) {
        if (n < 0) {
            return helper(1 / x, -1L * n);
        }
        return helper(x, n);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        double half = helper(x, n / 2);
        double res = half * half;
        if (n % 2 == 1) {
            res = res * x;
        }
        return res;
    }
}

// https://leetcode.com/problems/powx-n/description/
