package LeetCode;

public class TreeSimple {

    public static void main(String[] args) {
        TreeSimple obj = new TreeSimple();
        obj.isSubtree(TreeNode.arrayToTree(new Integer[]{3,4,5,1,2}),
                       TreeNode.arrayToTree(new Integer[]{4,1,2}) );
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (isEqual(root,subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    } // https://leetcode.com/problems/subtree-of-another-tree/description/

    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val) && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    } // https://leetcode.com/problems/invert-binary-tree/submissions/1410836326/


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    } // https://leetcode.com/problems/maximum-depth-of-binary-tree/


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    } // https://leetcode.com/problems/same-tree/


    public boolean isBalanced(TreeNode root) {
        int res = isBalancedInternal(root);
        return res >= 0;
    }

    public int isBalancedInternal(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        int l = isBalancedInternal(root.left);
        int r = isBalancedInternal(root.right);
        if (l < 0 || r < 0 || Math.abs(l-r) > 1) {
            return -1;
        }
        return Math.max(l,r) + 1;
    } // https://leetcode.com/problems/balanced-binary-tree/
}
