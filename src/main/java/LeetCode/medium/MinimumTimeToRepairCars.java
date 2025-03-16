package LeetCode.medium;

import java.util.Arrays;

public class MinimumTimeToRepairCars {

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long l = 1;
        long minrank = ranks[0];
        for (int i = 0; i < n; i++) {
            minrank = Math.min(minrank, ranks[i]);
        }
        long h = minrank * cars * cars; // maximum time if most efficient person does all cars.

        long res = h, mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;
            int doneCars = 0;
            for (int i = 0; i < n; i++) {
                long rank = ranks[i];
                //since: time = rank * car * car
                //so: car * car = (time/rank)
                //so: car = sqrt (time/rank)
                doneCars += Math.sqrt(mid/rank);
            }
            if (doneCars >= cars) {
                // all cars can be done within time mid
                res = mid;
                h = mid - 1;
            } else {
                // cant be done need more time
                l = mid + 1;
            }
        }

        return res;
    }

   public static void main(String[] args) {
        final MinimumTimeToRepairCars ob = new MinimumTimeToRepairCars();
        final long res = ob.repairCars(new int[]{4, 2, 3, 1}, 10);
        System.out.println("Result " + res);
    }
}

// https://leetcode.com/problems/minimum-time-to-repair-cars/
