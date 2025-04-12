package LeetCode.hard;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfPowerfulInteger {
    int res;
    Set<Long> resSet;
    int fDigit;

    public static void main(String[] args) {
        CountNumberOfPowerfulInteger ob = new CountNumberOfPowerfulInteger();
        final long res = ob.numberOfPowerfulInt(20, 1159, 5, "20");
        System.out.println("res " + res);
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long sNum = Long.parseLong(s);
        if (sNum > finish) return 0;
        int dig = s.length();
        int sDigit = ("" + start).length();
        fDigit = ("" + finish).length();
        res = 0;
        resSet = new HashSet<Long>();
        helper(start, finish, limit, s, dig);
        return resSet.size();
    }

    private void helper(long start, long finish, int limit, String s, int dig) {
        long num = Long.parseLong(s);
        if (num > finish || s.length() > fDigit) return;
        if (num >= start && num <= finish) {
//            if (resSet.contains(num)) return;
            resSet.add(num);
        }
        long pow = (long) Math.pow(10, dig);
        for (int i = 0; i <= limit; i++) {
            String newS = "" + i + s;
            helper(start, finish, limit, newS, dig + 1);
        }
    }
}

// https://leetcode.com/problems/count-the-number-of-powerful-integers/description/
