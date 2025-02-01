package LeetCode.easy;

public class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        int flag = 0;
        if (n == 1) return true;
        if (nums[0] % 2 == 0) {
            flag = 0;
        } else {
            flag = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                flag--;
            } else {
                flag++;
            }
            if(flag < 0 || flag > 1) return false;
        }

        return true;
    }
}
