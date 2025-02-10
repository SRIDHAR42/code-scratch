package LeetCode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        int[] q2 = new int[m];
        int i = 0;
        for (int q : queries) q2[i++] = q;
        Arrays.sort(q2);
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0]; // sorting based on start
        });

        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        Map<Integer, Integer> storedAns = new HashMap<>();

        i = 0;
        for (int idx = 0; idx < m; idx++) {
            int q = q2[idx];
            if (idx > 0 && q2[idx] == q2[idx -1]) continue; // no need to calculate twice.
            // store all potential intervals in min heap
            while (i < n && intervals[i][0] <= q) {
                // we store range and end of interval
                minHeap.put(intervals[i][1] - intervals[i][0] + 1, intervals[i][1]);
                i++;
            }
            // now all range is added in sorted manner in minheap
            // remove the range which has end interval < q becaise no overlap
            // when both start and end interval are < q
            while (!minHeap.isEmpty() && minHeap.firstEntry().getValue() < q) {
                minHeap.pollFirstEntry();
            }
            // if an entry reamin means that is smallest range that had q
            storedAns.put(q, (minHeap.isEmpty()) ? -1 : minHeap.firstEntry().getKey());
        }

        int[] ans = new int[m];
        for (int idx = 0; idx < m; idx++) {
            ans[idx] = storedAns.get(queries[idx]);
        }

        return ans;
    }
}

//https://leetcode.com/problems/minimum-interval-to-include-each-query/description/?envType=problem-list-v2&envId=plakya4j
