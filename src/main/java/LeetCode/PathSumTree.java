package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;

public class PathSumTree {
    long curr = 0;
    boolean found = false;

    public static void main(String[] args) {
        PathSumTree obj = new PathSumTree();
        obj.hasPathSum(TreeNode.arrayToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        curr = 0;
        found = false;
        traversePathSum(root, targetSum);
        return found;
    }

    private void traversePathSum(TreeNode root, int targetSum) {
        if (root == null || found) return;
        curr += root.val;
        if (root.left == null && root.right == null && curr == targetSum) {
            System.out.println("found at " + root.val);
            found = true;
            return;
        }
        traversePathSum(root.left, targetSum);
        traversePathSum(root.right, targetSum);
        curr -= root.val;
    }
}
