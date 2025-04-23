package LeetCode.medium;

import LeetCode.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Integer, Node> nodeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Node n1 = q.poll();
            if (visited.contains(n1.val)) continue;
            Node n2 = getOrCreate(nodeMap, n1);
            for (Node neighbor1 : n1.neighbors) {
                Node neighbour2 = getOrCreate(nodeMap, neighbor1);
                n2.neighbors.add(neighbour2);
                q.add(neighbor1);
            }
            visited.add(n1.val);
        }
        return getOrCreate(nodeMap, node);
    }

    private Node getOrCreate(Map<Integer, Node> nodeMap, Node n) {
        if (nodeMap.containsKey(n.val)) {
            return nodeMap.get(n.val);
        } else {
            Node newNode = new Node(n.val);
            nodeMap.put(newNode.val, newNode);
            return newNode;
        }
    }
}

// https://leetcode.com/problems/clone-graph/description