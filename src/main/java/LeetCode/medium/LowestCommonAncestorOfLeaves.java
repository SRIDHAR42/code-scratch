package LeetCode.medium;

import LeetCode.TreeNode;

public class LowestCommonAncestorOfLeaves {
    TreeNode res;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int currDepth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, currDepth);
            return currDepth;
        }

        int left = dfs(root.left, currDepth + 1);
        int right = dfs(root.right, currDepth + 1);

        if (left == right && left == maxDepth) res = root;
        return Math.max(left, right);
    }
}

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
