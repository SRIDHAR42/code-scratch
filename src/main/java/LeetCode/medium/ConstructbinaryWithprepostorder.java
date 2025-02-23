package LeetCode.medium;

import LeetCode.TreeNode;

public class ConstructbinaryWithprepostorder {
    int idx;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        idx = 0;
        return construct(preorder, postorder, 0, preorder.length -1);
    }

    private TreeNode construct(int[] pre, int[] post, int l, int h) {
        if (idx >= pre.length || l > h) return null;

        // make node of current idx
        TreeNode curr = new TreeNode(pre[idx]);
        // System.out.println("added " + pre[idx]);
        idx++;

        if (l == h) return curr; // only 1 element;

        int i;
        for (i = l; i <= h; i++) {
            if(post[i] == pre[idx]) break; // record where pre[idx] is present in post to split left and right
        }

        if (l <= h) {
            curr.left = construct(pre, post, l, i);
            curr.right = construct(pre, post, i + 1, h -1);
        }


        return curr;
    }
}

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
