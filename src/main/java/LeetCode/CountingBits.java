package LeetCode;

public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n+1];

        // set index 1,2,4,8... as -1
        for (int i = 2; i < n + 1; i = (i * 2)) {
            res[i] = -1;
        }
        res[0] = 0;
        int i = 1;
        int j = 0;
        while (i <=n) {
            if (res[i] == -1) {
                res[i] = 1;
                j = 1;
            } else {
                res[i] = res[j] + 1;
                j++;
            }
            i++;
        }
        return res;
    }

    public int[] countBitsTheirSulution(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // number will be number left shit 1 which is already gotten and check is last digit is 1.
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        for (int i = 17; i < 18; i++) {
            final int[] res = obj.countBits(i);
            System.out.println("for " + i + ": ");
            for (int re : res) {
                System.out.print(re + ", ");
            }

            System.out.println(" ");
        }
    }
}
// Counting Bits https://leetcode.com/problems/counting-bits/description/?envType=problem-list-v2&envId=plakya4j
