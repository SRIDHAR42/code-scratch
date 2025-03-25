package LeetCode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    List<List<String>> output;

    public static void main(String[] args) {
        NQueen ob = new NQueen();
        final List<List<String>> listList = ob.solveNQueens(4);
        System.out.println(listList);
    }

    public List<List<String>> solveNQueens(int n) {
        output = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");
            }
            res.add(row);
        }
        solve(n, res, 0);
        return output;
    }

    private void processResult(int n, List<List<String>> res) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String r = "";
            for (int j = 0; j < n; j++) {
                r = r + res.get(i).get(j);
            }
            result.add(r);
        }
        output.add(result);
    }

    private void solve(int n, List<List<String>> res, int curr) {
        if (curr == n) {
            processResult(n, res);
            return;
        }

        for (int i = 0; i < n; i++) {
            res.get(curr).set(i, "Q");
            if (safe(n, res, curr, i)) {
                solve(n, res, curr + 1);
            }
            res.get(curr).set(i, ".");
        }
    }

    private boolean safe(int n, List<List<String>> res, int r, int c) {
        // check row
        int queen = 0;
        for (int i = 0; i < n; i++) {
            if (res.get(r).get(i).equals("Q")) queen++;
        }
        if (queen > 1) return false;

        queen = 0;
        for (int i = 0; i < n; i++) {
            if (res.get(i).get(c).equals("Q")) queen++;
        }
        if (queen > 1) return false;

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (res.get(i).get(j).equals("Q")) return false;
        }

        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (res.get(i).get(j).equals("Q")) return false;
        }

        return true;
    }
}
