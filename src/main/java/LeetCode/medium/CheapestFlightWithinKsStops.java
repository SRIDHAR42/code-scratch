package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithinKsStops {

    List<List<Integer>> graph;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        initializeGraph(n);

        int s = 0, d = 0, c = 0;
        for (int i = 0; i < flights.length; i++) {
            s = flights[i][0]; d = flights[i][1]; c = flights[i][2];
            graph.get(s).add(d, c);
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = -1;
        }
        cost[src] = 0;

        // do bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int count = 0;
        while (!q.isEmpty() && count++ < k) {
            final Integer source = q.poll();
            final List<Integer> list = graph.get(source);
            for (int hop : list) {
                System.out.println("processing " + hop);
                 int currcost = cost[source] + graph.get(source).get(hop);
                 if (cost[hop] == -1 || cost[hop] > currcost) {
                     cost[hop] = currcost;
                     q.add(hop);
                 }

            }
        }
        return cost[dst];
    }

    private void initializeGraph(int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, createArrayList(n));
        }
    }

    private List<Integer> createArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(0);
        }
        return list;
    }

    public static void main(String[] args) {
        CheapestFlightWithinKsStops ob = new CheapestFlightWithinKsStops();
        ob.findCheapestPrice(2, new int[][]{{0,1,3}}, 0,1,2);
    }

}

//https://leetcode.com/problems/cheapest-flights-within-k-stops/?envType=problem-list-v2&envId=plakya4j