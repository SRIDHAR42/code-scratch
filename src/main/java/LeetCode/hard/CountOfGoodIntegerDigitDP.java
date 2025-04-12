package LeetCode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountOfGoodIntegerDigitDP {
    long res;
    Set<String> visited;

    private long arrayToNum(int[] palin) {
        long res = 0;
        for (int i = 0; i < palin.length; i++) {
            res = (res * 10) + palin[i];
        }
        return res;
    }

    private long totalPerm(HashMap<Integer, Integer> freq, int total) {
        long totFact = fact(total);
        long temp;
        for (int val : freq.values()) {
            temp = fact(val);
            totFact = totFact / temp;
        }
        return totFact;
    }

    private long fact(long n) { // simply return factorial of n
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private long permWithZero(HashMap<Integer, Integer> freq, int total) {
        // if no zeros the no need to calculate
        if (!freq.containsKey(0) || freq.get(0) == 0) return 0;
        freq.put(0, freq.get(0) - 1); // remove one 0
        long totFact = fact(total - 1); // since we remove one 0 so total digit is 1 less
        long temp;
        for (int val : freq.values()) {
            temp = fact(val);
            totFact = totFact / temp;
        }
        return totFact;
    }

    private void helper(int[] palin, int left, int right, int divisor, int total) {
        if (left > right) {
            // exit condition;
            long num = arrayToNum(palin);
            if (num % divisor == 0) {
                HashMap<Integer, Integer> freq = new HashMap<>();
                for (int d : palin) {
                    freq.put(d, freq.getOrDefault(d, 0) + 1);
                }
                String visitedKey = freq.toString(); // so all key value is put as string
                if (!visited.contains(visitedKey)) {
                    // not yet added to visited
                    res += totalPerm(freq, total) - permWithZero(new HashMap<>(freq), total);
                    visited.add(visitedKey);
                }
            }
            return;
        }

        // normal case, create enumerations
        for (int i = 0; i <= 9; i++) {
            if (left == 0 && i == 0) continue; // dont put 0 in 0th position
            palin[left] = i;
            palin[right] = i;
            helper(palin, left + 1, right - 1, divisor, total);
        }
    }

    public long countGoodIntegers(int total, int divisor) {
        res = 0;
        visited = new HashSet<>();
        helper(new int[total], 0, total - 1, divisor, total);
        return res;
    }
}

// https://leetcode.com/problems/find-the-count-of-good-integers/description/
