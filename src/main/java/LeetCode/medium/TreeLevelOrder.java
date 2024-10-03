package LeetCode.medium;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {

    public static void main(String[] args) {
        TreeLevelOrder obj = new TreeLevelOrder();
        final List<List<Integer>> lists =
                obj.levelOrder(TreeNode.arrayToTree(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }

            }
            if (!nextLevel.isEmpty()) {
                queue = nextLevel;
            }
            res.add(level);

        }
        return res;
    }
}
