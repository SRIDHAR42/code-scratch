package LeetCode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class GoodNode {

    int count;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        count = 1;
        goodNodesInternal(root.left, root.val);
        goodNodesInternal(root.right, root.val);
        return count;
    }

    private void goodNodesInternal(TreeNode node, int val) {
        if (node == null) return;
        if (node.val >= val) count++;
        goodNodesInternal(node.left, Math.max(val, node.val));
        goodNodesInternal(node.right, Math.max(val, node.val));
    }

}
