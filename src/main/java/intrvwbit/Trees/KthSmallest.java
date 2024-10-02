package intrvwbit.Trees;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallest {
    public int kthsmallest(TreeNode A, int B) {
        PriorityQueue<Integer> s = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        DFS_KTH( A, B, s);
        return (s.size()>0)? s.peek():0;
    }

    private void DFS_KTH(TreeNode a, int b, PriorityQueue<Integer> s) {
        if (a != null ) {
            s.add(a.val);
            if (s.size() > b) {
                s.poll();
            }
            DFS_KTH(a.left, b, s);
            DFS_KTH(a.right, b, s);
        }
    }


}
