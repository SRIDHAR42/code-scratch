package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectSquares {

    List<int[]> coordinates;
    Map<String, Integer> count;

    public DetectSquares() {
        coordinates = new ArrayList<>();
        count = new HashMap<>();
    }

    public void add(int[] point) {
        coordinates.add(point);
        String s = point[0] + "#" + point[1];
        count.put(s, count.getOrDefault(s, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0, px = point[0], py = point[1];
        for (int i = 0; i < coordinates.size(); i++) {
            int x = coordinates.get(i)[0], y = coordinates.get(i)[1];
            if (x == px || y == py) continue; // parallel
            if (Math.abs(x - px) != Math.abs(y - py)) continue; // length of side diff so not a square
            res += count.getOrDefault(x + "#" + py, 0) * count.getOrDefault(px + "#" + y, 0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */

// https://leetcode.com/problems/detect-squares/description/
