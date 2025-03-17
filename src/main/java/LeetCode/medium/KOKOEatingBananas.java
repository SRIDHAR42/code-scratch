package LeetCode.medium;

public class KOKOEatingBananas {
    public int minEatingSpeed(int[] piles, int hour) {
        int l = 1, h = Integer.MIN_VALUE;
        long capacity = 0;
        for (int i = 0; i < piles.length; i++) {
            h = Math.max(h, piles[i]);
        }
        int res = h, mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            // System.out.println("checking " + mid);
            if (finishAllAtRate(piles, hour, mid)) {
                // can finish so check is lower values is possible
                res = Math.min(res, mid);
                h = mid - 1;
                // System.out.println("res set " + res);
            } else {
                // not finished need to increase rate banana/hour
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean finishAllAtRate(int[] piles, int hour, int rate) {
        long total_time = 0;
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            time = piles[i] / rate;
            time += (piles[i] % rate == 0) ? 0 : 1;
            total_time += time;
            if (total_time > hour) return false;
        }
        return total_time <= hour;
    }
}

// https://leetcode.com/problems/koko-eating-bananas/description/
