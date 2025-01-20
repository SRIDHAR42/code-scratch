package LeetCode;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur < 0) {
                // switch min max;
                int temp = min;
                min = max;
                max = temp;
            }

            min = Math.min(cur, min * cur);
            max = Math.max(cur, max * cur);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProductSubArray obj = new MaxProductSubArray();
        final int res = obj.maxProduct(new int[]{-2, 3, -4});
        System.out.println("res " + res);
    }
}
