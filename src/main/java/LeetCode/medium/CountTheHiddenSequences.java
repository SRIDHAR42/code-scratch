package LeetCode.medium;

public class CountTheHiddenSequences {
    int res;

    public static void main(String[] args) {
        CountTheHiddenSequences ob = new CountTheHiddenSequences();
        final int result = ob.numberOfArrays(new int[]{1, -3, 4}, 1, 6);
        System.out.println("result " + result);

    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        res = 0;
        for (int i = lower; i <= upper; i++) {
            System.out.println("starting with " + i);
            helper(differences, lower, upper, i, 0);
        }
        return res;
    }

    private void helper(int[] differences, int lower, int upper, int curr, int idx) {
        if (curr < lower || curr > upper) return;
        if (idx > differences.length) return;
        if (idx == differences.length) {
            res++;
            System.out.println("done");
            return;
        }
        curr = curr + differences[idx];
        if (curr < lower || curr > upper) return;

        System.out.println("curr " + curr);
        for (int i = lower; i <= upper; i++) {
            helper(differences, lower, upper, curr, idx + 1);
        }
    }
}

// https://leetcode.com/problems/count-the-hidden-sequences/description/
