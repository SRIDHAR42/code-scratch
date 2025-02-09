package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ColorBallsLimit {
    public int[] queryResults(int limit, int[][] queries) {
        int qsize = queries.length;

        int[] res = new int[qsize];

        Map<Integer, Integer> colorCount = new HashMap<>();
        int[] ballColor = new int[limit + 1]; // limit + 1 balls

        for (int i = 0; i < qsize; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];

            int oldColor = ballColor[ball]; // curr color of ith ball
            if (oldColor == 0) {
                // no color
                ballColor[ball] = color;
                // colorCount.merge(color, 1, Integer::sum);
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            } else {
                // reduce current color count
                Integer oldColorCount = colorCount.get(oldColor);
                if (oldColorCount != null && oldColorCount == 1) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, oldColorCount - 1);
                }
                // add new color count
                ballColor[ball] = color;
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
            System.out.println("i " + i + " color " + colorCount.size());
            res[i] = colorCount.size();

        }
        return res;
    }

    public static void main(String[] args) {
        ColorBallsLimit colorBallsLimit = new ColorBallsLimit();
        final int[] res = colorBallsLimit.queryResults(4, new int[][]{
                {1, 4}, {2, 5}, {1, 3}, {1, 4}
        });
        System.out.println(res);
    }
}
