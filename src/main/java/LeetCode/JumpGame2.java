package LeetCode;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] hop = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = i + 1;
            int count = hop[i] + 1;
            for (int j = 0; j < nums[i] && idx < n; j++) {
                hop[idx] = count;
                if (idx == n -1) {
                    return hop[n-1];
                }
                idx++;
            }
        }
        return hop[n-1];
    }

    public static void main(String[] args) {
        JumpGame2 obj = new JumpGame2();
        final int sol = obj.jump(new int[]{2, 3, 1, 1, 4});
    }
}

// https://leetcode.com/problems/jump-game-ii/?envType=problem-list-v2&envId=plakya4j

