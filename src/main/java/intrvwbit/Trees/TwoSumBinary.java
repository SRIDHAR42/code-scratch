package intrvwbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumBinary {
    public int t2Sum(TreeNode A, int B) {
        Set<Integer> s = new HashSet<>();
        return t2SumInternal(A, B, s);
    }

    private int t2SumInternal(TreeNode a, int b, Set<Integer> s) {
        if (a == null ) return 0;
        int left = t2SumInternal(a.left, b, s);
        if (left == 1) {
            return 1;
        }
        if (s.contains(a.val)) {
            return 1;
        }
        if (b > a.val) {
            s.add(b - a.val);
        }
        return t2SumInternal(a.right, b, s);
    }

    public static void main(String[] args) {
        final TwoSumBinary ins = new TwoSumBinary();
        ins.t2Sum(MakeTree.makeTree(new ArrayList<>(
                Arrays.asList(558, 134, 765, 35, 198, 741, 868, -1, 55, -1, 442, 729, 761, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)))
                ,253);
    }
}
