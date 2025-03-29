package LeetCode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ApplyOperationToMaxScore {
    private final int mod = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; i++) {
            // idx, primeFac, Val
            arr[i] = new int[]{i, primeFactors(nums.get(i)), nums.get(i)};
        }
        int[] left = new int[n]; // store index of  max primeF from the left
        int[] right = new int[n]; // store index of  max primeF from the right
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], primeF = arr[i][1];
            // System.out.println("arr[idx][0] " + arr[idx][0] + " i " + i);
            while (!st.isEmpty() && arr[st.peek()][1] < primeF) {
                st.pop();
            }
            if (st.size() > 0) {
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int idx = i, primeF = arr[idx][1];
            while (!st.isEmpty() && arr[st.peek()][1] <= primeF) {
                st.pop();
            }
            if (st.size() > 0) {
                right[i] = st.peek();
            }
            st.push(i);
        }

        // arr is idx, primeFac, Val
        // sort arr descending as by value so we can maximise in multiplying score.
        Arrays.sort(arr, (a, b) -> {
            return b[2] - a[2];
        });

        long ans = 1;
        for (int[] e : arr) {
            int val = e[2], i = e[0];  // ✅ Use original idx
            int l = left[i], r = right[i];     // ✅ Correct indexing using idx
            long maxSubArrayCreated = (long) (i - l) * (r - i);
            if (maxSubArrayCreated <= k) {
                ans = ans * qPow(val, maxSubArrayCreated) % mod;
                k -= maxSubArrayCreated;
            } else {
                // can only perform k operations
                ans = ans * qPow(val, k) % mod;
                break;
            }
        }

        return (int) ans;
    }

    private int primeFactors(int n) {
        Set<Integer> ans = new HashSet<>();
        int i = 2;
        while (i <= n / i) {
            while (n % i == 0) {
                ans.add(i);
                n = n / i;
            }
            i++;
        }
        // if n itself is a prime num
        if (n > 1) ans.add(n);
        return ans.size();
    }

    private int qPow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = (a * a % mod);
        }
        return (int) ans;
    }
}

// https://leetcode.com/problems/apply-operations-to-maximize-score/description/
