package LeetCode.hard;

import LeetCode.TreeNode;

import java.util.Stack;

public class RecoverFromPreOrderTree {

    public TreeNode recoverFromPreorder(String s) {
        int idx = 0;
        String num = "";
        while(idx < s.length() && s.charAt(idx) != '-') {
            num += s.charAt(idx);
            idx++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(num));
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(idx < s.length()) {
            int depth = 0;
            while(s.charAt(idx) == '-') {
                depth++;
                idx++;
            }

            while(st.size() > depth) st.pop();

            TreeNode tmp = st.peek();
            if (tmp.left == null) {
                num = "";
                while(idx < s.length() && s.charAt(idx) != '-') {
                    num += s.charAt(idx);
                    idx++;
                }
                tmp.left = new TreeNode(Integer.parseInt(num));
                st.push(tmp.left);
            } else {
                num = "";
                while(idx < s.length() && s.charAt(idx) != '-') {
                    num += s.charAt(idx);
                    idx++;
                }
                tmp.right = new TreeNode(Integer.parseInt(num));
                st.push(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        RecoverFromPreOrderTree ob = new RecoverFromPreOrderTree();
        final TreeNode treeNode = ob.recoverFromPreorder("1-401--349---90--88");
        System.out.println(treeNode);
    }
}

// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
