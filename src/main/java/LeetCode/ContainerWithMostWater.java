package LeetCode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        final int i = obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println("soln: " + i);
    }

    public int maxArea(int[] height) {
        int res = 0, curr = 0;
        int i = 0, j = height.length - 1;
        while (i<j) {
//            System.out.println("i=" + i + " j=" + j + "height[i],height[j] = " + height[i] + " " +height[j]);
            curr = (j-i) * Math.min(height[i],height[j]);
//            System.out.println("curr " + curr);
            res = Math.max(res,curr);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
