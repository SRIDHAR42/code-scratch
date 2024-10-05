package LeetCode;

import java.util.ArrayList;

public class TreeLowestCommonAncestor {
    public static void main(String[] args) {
        TreeLowestCommonAncestor obj = new TreeLowestCommonAncestor();
//        TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{2,1});
//        final TreeNode treeNode1 = obj.lowestCommonAncestor(treeNode, treeNode.left.right.right, treeNode.right.left);
        final TreeNode treeNode1 = obj.lowestCommonAncestor(treeNode, treeNode, treeNode.left);
        System.out.println(treeNode1.val);
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> an1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> an2 = new ArrayList<TreeNode>();
        getAncestoer(root, p, an1);
        getAncestoer(root, q, an2);
        TreeNode res = root;
        for (int i = 0; i < an1.size() && i < an2.size(); i++) {
            if (an1.get(i) == an2.get(i)) {
                res = an1.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    public boolean getAncestoer(TreeNode root, TreeNode p ,ArrayList<TreeNode> an) {
        if (root == null) return false;
        an.add(root);
        if (root.val == p.val) {
            return true;
        }
        if (getAncestoer(root.left, p, an)) {
            return true;
        }
        if (getAncestoer(root.right, p, an)) {
            return true;
        }
        an.remove(root);
        return false;
    }
}
