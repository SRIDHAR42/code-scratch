package LeetCode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root, true);
        int r = depth(root, false);
        if (l == r) {
            return (int) Math.pow(2, l) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int depth(TreeNode root, boolean seekLeft) {
        int res = 0;
        while (root != null) {
            res++;
            if (seekLeft) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
