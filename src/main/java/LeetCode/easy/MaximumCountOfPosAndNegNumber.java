package LeetCode.easy;

public class MaximumCountOfPosAndNegNumber {
    public int maximumCount(int[] nums) {
        int neg = position(nums, 0);
        System.out.println("negative numbers " + neg);
        int pos = nums.length - position(nums, 1);
        System.out.println("postive numbers " + pos);
        return Math.max(pos, neg);
    }

    private int position(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n -1;
        int mid = low;
        int res = n;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final MaximumCountOfPosAndNegNumber ob = new MaximumCountOfPosAndNegNumber();
        ob.maximumCount(new int[]{-1563,-236,-114,-55,427,447,687,752,1021,1636});
        ob.maximumCount(new int[]{-2,-1,-1,1,2,3});

    }
}
