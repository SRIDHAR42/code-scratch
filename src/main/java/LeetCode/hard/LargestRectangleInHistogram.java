package LeetCode.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max_area = 0;
        int height = 0, width = 0;
        for (int i = 0; i < heights.length; i++) {
            while (st.peek() != -1 && heights[i] <= heights[st.peek()]) {
                height = heights[st.peek()];
                st.pop();
                width = i - st.peek() - 1;
                max_area = Math.max(max_area, height * width);
            }
            st.push(i);
        }

        while (st.peek() != -1) {
            height = heights[st.peek()];
            st.pop();
            width = heights.length - st.peek() - 1;
            max_area = Math.max(max_area, height * width);
        }

        return max_area;
    }
}
