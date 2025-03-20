package LeetCode.hard;

public class MinimumCostWalkInWeightedGraph {
    int[] parent;

    private void union(int x, int y) {
        int xR = findRoot(x);
        int yR = findRoot(y);
        if (xR != yR) {
            parent[yR] = xR;
        }
    }

    private int findRoot(int x) {
        if (parent[x] != x) {
            parent[x] = findRoot(parent[x]); // path compression
        }
        return parent[x];
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        int[] mincost = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            mincost[i] = -1;
        }

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0], d = edges[i][1], w = edges[i][2];
            int pS = findRoot(s);
            int pD = findRoot(d);
            mincost[pS] = mincost[pS] & mincost[pD]; // update parent with mincost dest previously
            mincost[pS] = mincost[pS] & w; // update parent with mincost of curr edge
            union(s, d); // union to mark parent same;
            // System.out.println("p" + p + "processing " + i + "mincost[p] " + mincost[p]);
        }

        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int sR = findRoot(query[i][0]), dR = findRoot(query[i][1]);
            if (sR != dR) {
                res[i] = -1; // not reachable diff root.
            } else {
                res[i] = mincost[sR];
            }
        }

        return res;
    }


}

// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/
