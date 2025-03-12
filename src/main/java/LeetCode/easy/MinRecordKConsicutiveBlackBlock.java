package LeetCode.easy;

public class MinRecordKConsicutiveBlackBlock {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        System.out.println("String size " + n);
        int black = 0;
        int i = 0;
        while (i < k) {
            System.out.println("index " + i);
            if (blocks.charAt(i) == 'W') black++;
            i++;
        }
        int res = black;
        // System.out.println("result at " + i + " " + res);
        while (i < n && res > 0) {
            // System.out.println("index " + i + " remove" + blocks.charAt(i-k) + " add" + blocks.charAt(i));
            if (blocks.charAt(i) == blocks.charAt(i-k)) {
                i++;
                continue;
            }
            if (blocks.charAt(i) == 'W' && blocks.charAt(i-k) == 'B') {
                black++;
            }
            else if (blocks.charAt(i) == 'B' && blocks.charAt(i-k) == 'W') {
                black--;
            }
            res = Math.min(res, black);
            // System.out.println("result at " + i + " " + black);
            i++;
        }
        return (res < 0)? 0 : res;
    }
}

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
