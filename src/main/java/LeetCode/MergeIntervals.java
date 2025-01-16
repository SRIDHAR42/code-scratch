package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> st = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        st.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            final int[] ele1 = st.get(st.size() - 1);
            final int[] ele2 = intervals[i];
            if (ele2[0] > ele1[1]) { // not overlap
                st.add(ele2);
            } else {
                ele1[1] = Math.max(ele1[1], ele2[1]);
            }
        }
        return st.toArray(new int[st.size()][]);

    }
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        final int[][] merge = obj.merge(new int[][]{
                {1,3}, {2,6}, {8,10}, {15,18}, {1, 18}
        });
    }
}
