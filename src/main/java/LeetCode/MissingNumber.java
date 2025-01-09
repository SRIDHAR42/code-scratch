package LeetCode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean has0 = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = n + 1;
                nums[0] = -1 * nums[0];
                has0 = true;
            }
        }
        if (!has0) return 0;

        int num;
        for (int i = 0; i < n; i++) {
            num = Math.abs(nums[i]);
            if (num <= n-1) {
                nums[num] = -1 * nums[num];
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }
        return n;
    }

    public int missingNumber_THEIR_SOLUTION(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(new int[]{3,0,1}));
        System.out.println(obj.missingNumber(new int[]{0,1}));
        System.out.println(obj.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
// https://leetcode.com/problems/missing-number/description/?envType=problem-list-v2&envId=plakya4j&difficulty=EASY

