package LeetCode.medium;

public class MaximumCandiesKChildren {

    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = getMax(candies);
        int res = 0, mid = 0;
        while (low <= high) {
            mid = low + (high - low)/2;
            // System.out.println("checking " + mid);
            if (isPossible(candies, mid, k)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] candies,int mid, long k) {
        // returns true if candies can be divided into mid sise piles and #piles >= k
        for (int i = 0; i < candies.length; i++) {
            k -= candies[i]/mid;
            if (k <= 0) return true;
        }
        return false;
    }

    private int getMax(int[] candies) {
        int res = 0;
        for (int i = 0; i < candies.length; i++) {
            res = Math.max(res, candies[i]);
        }

        return res;
    }
}
