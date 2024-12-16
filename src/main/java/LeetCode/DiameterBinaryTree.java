package LeetCode;

public class DiameterBinaryTree {

    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        runInOrderTraversalMaxLen(root);
        System.out.println("diameter = " + (diameter - 1));
        return diameter - 1;
    }

    private int runInOrderTraversalMaxLen(TreeNode root) {
        if (root == null) return 0;
        int l = runInOrderTraversalMaxLen(root.left);
        int r = runInOrderTraversalMaxLen(root.right);
        diameter = Math.max(diameter, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        final TreeNode root = TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, 5});
        DiameterBinaryTree obj = new DiameterBinaryTree();
        obj.diameterOfBinaryTree(root);
    }


}

//https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=plakya4j&difficulty=EASY
