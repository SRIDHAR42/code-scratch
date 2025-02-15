package LeetCode.hard;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerialiseDeSerialiseBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        List<String> list = new ArrayList();
        parse(root, list);
        StringBuilder sb = new StringBuilder();
        int n = list.size();
        if (n == 0) return "";
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n-1) sb.append(",");
        }
        return sb.toString();
    }

    private void parse(TreeNode root, List<String> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp == null) {
             list.add("null");
             continue;
            }
            list.add(tmp.val + "");
            q.add(tmp.left);
            q.add(tmp.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        String[] split = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int val = Integer.parseInt(split[0]);
        TreeNode root = new TreeNode(val);
        q.add(root);
        int i = 1;
        while (i < split.length && !q.isEmpty()) {
            TreeNode node = q.poll();
            String sNodeLeft = split[i++];
            String sNodeRight = split[i++];
            if (!sNodeLeft.equals("null")) {
                val = Integer.parseInt(sNodeLeft);
                TreeNode temp = new TreeNode(val);
                node.left = temp;
                q.add(temp);
            }
            if (!sNodeRight.equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(sNodeRight));
                node.right = temp;
                q.add(temp);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        SerialiseDeSerialiseBinaryTree ob = new SerialiseDeSerialiseBinaryTree();
        TreeNode exp = TreeNode.arrayToTree(new Integer[]{1,2,3,null,null,4,5});
        final String serializeString = ob.serialize(exp);
        final TreeNode tree = ob.deserialize(serializeString);
        System.out.println(tree);


    }
}
