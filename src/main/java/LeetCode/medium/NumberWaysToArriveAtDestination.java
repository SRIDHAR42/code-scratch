package LeetCode.medium;

import java.util.*;

public class NumberWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        // make adj
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // fill graph
        int s, d, t;
        for (int i = 0; i < roads.length; i++) {
            s = roads[i][0];
            d = roads[i][1];
            t = roads[i][2];
            graph.get(s).add(new int[]{d, t});
            graph.get(d).add(new int[]{s, t});
        }
        long inf = Long.MAX_VALUE;
        long[] dist = new long[n]; // to store distance
        int[] ways = new int[n]; // to store number to ways to reach node;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            dist[i] = inf;
            ways[i] = 0;
        }

        dist[0] = 0; // 0 distance at origin
        ways[0] = 1; // 1 way at origin

        Queue<long[]> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a[0], b[0]);
        }); // priority queue to pair(time_to_reach_node, node) sorted by time_to_reach_node;

        pq.add(new long[]{dist[0], 0});
        while (!pq.isEmpty()) {
            long[] pqElement = pq.poll();
            long currDist = pqElement[0];
            int curr = (int) pqElement[1];

            if (currDist > dist[curr]) continue; // already array update to minumum dist.

            // for each neighbour of curr node update the dist and ways
            for (int[] adj : graph.get(curr)) {
                int nextNode = adj[0];
                int nextT = adj[1];
                if (dist[curr] + nextT < dist[nextNode]) {
                    // new minimum dist/time to reach nextNode
                    dist[nextNode] = dist[curr] + nextT;
                    //only 1 way to reach
                    ways[nextNode] = ways[curr];
                    // add in priorityqueue to process
                    pq.add(new long[]{dist[nextNode], nextNode});
                } else if (dist[curr] + nextT == dist[nextNode]) {
                    // same time but number of ways added
                    ways[nextNode] = (ways[nextNode] + ways[curr]) % mod;
                }
            }
        }

        return ways[n - 1];
    }

    public static void main(String[] args) {
        NumberWaysToArriveAtDestination ob = new NumberWaysToArriveAtDestination();
        final int res = ob.countPaths(7,
                new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}});
        System.out.println("res " + res);
    }
}

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
