package LeetCode;

import java.util.ArrayList;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        kthSmallestBSTInternal(root, arr, k);
        return arr.get(k-1);
    }

    private void kthSmallestBSTInternal(TreeNode root, ArrayList<Integer> arr, int k) {
        if (root == null || arr.size() == k) return;
        kthSmallestBSTInternal(root.left, arr, k);
        if (arr.size() < k) {
            arr.add(root.val);
        }
        kthSmallestBSTInternal(root.right, arr, k);
    }
}
