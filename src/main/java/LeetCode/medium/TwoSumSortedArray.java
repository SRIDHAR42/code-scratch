package LeetCode.medium;

public class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int n = numbers.length;
        int sum = 0;
        while (i < j) {
            // System.out.println("i " + i + " j " + j);
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        final TwoSumSortedArray ob = new TwoSumSortedArray();
        final int[] res = ob.twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200);
        System.out.println(res);
    }
}
