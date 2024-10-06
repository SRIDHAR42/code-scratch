package LeetCode;

public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST obj = new SortedArrayToBST();
        final TreeNode treeNode = obj.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        int low = 0;
        int high = nums.length - 1;
        int mid =(high + low)/2;
        root.val = nums[mid];
        System.out.println("value added " + root.val);
        maketree(root, nums, 0, mid -1);
        maketree(root, nums, mid+1, high);
        return root;
    }

    public void maketree(TreeNode root, int[] nums, int low, int high) {
        if (low < 0 || high >= nums.length || low > high) return;
        System.out.println("low high " + low + " " + high);
        int mid = (low + high)/2;
        TreeNode newNode = new TreeNode();
        newNode.val = nums[mid];
        System.out.println("value added " + newNode.val);
        if (root.val> nums[mid]) {
            root.left = newNode;
        } else {
            root.right = newNode;
        }
        maketree(newNode, nums, low, mid - 1);
        maketree(newNode, nums, mid + 1, high);
    }
}
