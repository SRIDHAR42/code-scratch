package LeetCode.medium;

public class LexicographicallyLargestSequence {

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[ 2 * n -1];
        boolean[] visited = new boolean[n + 1];
        backtrack(ans, n , visited, 0);
        return ans;
    }

    private boolean backtrack(int[] ans, int n, boolean[] visited, int idx) {
        System.out.println("Currently " + idx);
        while (idx < ans.length && ans[idx] != 0) {
            idx++;
        }

        if (idx == ans.length) {
            return true; // all filled.
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) continue;

            if (i == 1) {
                // set idx 1
                visited[1] = true;
                ans[idx] = 1;
                if (backtrack(ans, n, visited, idx + 1)) return true;

                // if backtrack is not true then unset.
                visited[1] = false;
                ans[idx] = 0;


            } else {
                if (idx + i < ans.length && ans[idx + i] == 0) {
                    visited[i] = true;
                    ans[idx] = i;
                    ans[idx + i] = i;
                    if (backtrack(ans, n, visited, idx + 1)) return true;
                    // if backtrack is not true then unset.
                    visited[i] = false;
                    ans[idx] = 0;
                    ans[idx + i] = 0;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LexicographicallyLargestSequence ob = new LexicographicallyLargestSequence();
        final int[] res = ob.constructDistancedSequence(60);
        System.out.println(res);
    }
}
