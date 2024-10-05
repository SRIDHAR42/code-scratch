package LeetCode;

public class ValidateBSTTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE); // since the problem range is int we use long
        // because Integer_MIN MAX cases is also present
    }

    public boolean validate(TreeNode a, long min, long max) {
        if (a == null) return true;
        if (a.val <= min || a.val >= max) return false; // invalid
        return validate(a.left, min, a.val) && validate(a.right, a.val, max);
    } // https://leetcode.com/problems/validate-binary-search-tree/description/
}
