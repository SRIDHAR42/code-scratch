package LeetCode;

public class MergeTriplets {


    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < triplets.length; i++) {
            if (x < target[0] && triplets[i][0] <= target[0]) {
                x = Math.max(x, triplets[i][0]);
            }
            if (y < target[1] && triplets[i][1] <= target[1]) {
                y = Math.max(y, triplets[i][1]);
            }
            if (z < target[2] && triplets[i][2] <= target[2]) {
                z = Math.max(z, triplets[i][2]);
            }

            if (x == target[0] && y == target[1] && z == target[2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MergeTriplets obj = new MergeTriplets();
        final boolean res = obj.mergeTriplets(new int[][]{
                {2, 5, 3}, {1, 8, 4}, {1, 7, 5}
        }, new int[]{2, 7, 5});
        System.out.println("res: " + res);
    }
}
