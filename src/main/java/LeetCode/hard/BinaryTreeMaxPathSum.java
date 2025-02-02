package LeetCode.hard;

import LeetCode.TreeNode;

public class BinaryTreeMaxPathSum {

    private int res = 0;
    public int maxPathSum(TreeNode root) {
        this.res = root.val;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // max in left side
        // max in right side path
        // does max happend when we include
        int left = helper(root.left);
        int right = helper(root.right);

        int curr = root.val;
        int side = 0;
        if (left >= 0) {
            curr += left;
            side = Math.max(side, left);
        }
        if (right >= 0) {
            curr += right;
            side = Math.max(side, right);
        }

        this.res = Math.max(this.res, curr);
        return root.val + side;
    }
}
