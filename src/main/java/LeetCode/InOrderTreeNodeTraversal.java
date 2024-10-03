package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class InOrderTreeNodeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<Integer>();
        inorderInternal(root, inOrderList);
        return inOrderList;
    }

    public void inorderInternal(TreeNode root, List<Integer> inOrderList) {
        if (root == null ) return;
        inorderInternal(root.left, inOrderList);
        inOrderList.add(root.val);
        inorderInternal(root.right, inOrderList);
    }
}
