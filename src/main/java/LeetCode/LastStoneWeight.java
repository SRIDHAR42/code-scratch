package LeetCode;

public class LastStoneWeight {

    int xIndex = -1;
    int xWeight = -1;
    int yIndex = -1;
    int yWeight = -1;

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        while (true) {
            populateStones(stones);
            System.out.println("xIndex " + xIndex + ", xWeight " +  xWeight + ", yIndex " + yIndex + ", yWeight " + yWeight);
            if (xIndex == -1) return 0; // no item left with >0 weight; all destroyed
            if (yIndex == -1) return xWeight; // Only one weight left with >0 weight; return that;

            int newWeight = Math.abs(xWeight - yWeight);
            stones[xIndex] = newWeight; // remaining weight put on xIndex
            stones[yIndex] = 0;
        }
    }

    private void populateStones(int[] stones) {
        yWeight = xWeight = yIndex = xIndex = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > 0 && stones[i] >= xWeight) {
                xWeight = stones[i];
                xIndex = i;
            }
        }

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > 0 && stones[i] >= yWeight && i != xIndex) {
                yWeight = stones[i];
                yIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
        new LastStoneWeight().lastStoneWeight(new int[]{2,7,4,1,8,1})
        );
    }
}

// https://leetcode.com/problems/last-stone-weight/description/?envType=problem-list-v2&envId=plakya4j&difficulty=EASY
