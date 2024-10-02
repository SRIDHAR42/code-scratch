package intrvwbit.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * There are 1 lines in the input
 *
 * Line 1 ( Corresponds to arg 1 ) : First number represents the number of integers in input line.
 * Then follows serialized representation of the tree.
 * The serialization of a binary tree follows a level order description of left and right child of nodes, where -1 signifies a NULL child.
 *     For example,
 *          1
 *         / \
 *        2    3
 *           /
 *         4
 *          \
 *           5
 *     will have representation as {1 2 3 -1 -1 4 -1 -1 5 -1 -1}
 *     The first integer on the line indicates the number of integers to follow in the serialized representation of the tree.
 */

public class MakeTree {

    public static TreeNode makeTree(ArrayList<Integer> a) {
        int n = a.size();
        TreeNode root = null;
        ArrayList<TreeNode> tAtrray = new ArrayList<TreeNode>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (a.get(0) != -1) {
            root = new TreeNode(a.get(0));
            queue.add(root);
        }
        int i = 0;
        while (i < n && !queue.isEmpty()) {
            TreeNode parent = queue.poll();

            // left val
            i++;
            int left = a.get(i);
            i++;
            int right = a.get(i);
            if (left != -1) {
                TreeNode leftchild = new TreeNode(left);
                parent.left = leftchild;
                queue.add(leftchild);
                System.out.println(parent.val + " left " + left);
            }
            if (right != -1) {
                TreeNode rightChild = new TreeNode(right);
                parent.right = rightChild;
                queue.add(rightChild);
                System.out.println(parent.val + " right " + right);
            }
        }
        printTree(root);
        return root;

    }

    private static void printTree(TreeNode root) {
        return;
    }

    public static void main(String[] args) {
        makeTree(new ArrayList<>(Arrays.asList(1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1)));
    }
}
