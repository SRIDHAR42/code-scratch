package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        final char[][] chars = obj.stringToCharArray("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        final boolean validSudoku = obj.isValidSudoku(chars);
        System.out.println("validSudoku: " + validSudoku);
    }


    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int i, j;
        boolean valid = false;
        // rows
        for (i = 0; i < n; i++) {
            ArrayList<Integer> rowElements = new ArrayList<>();
            ArrayList<Integer> columnElements = new ArrayList<>();
            for (j = 0; j < n; j++) {
                if (board[i][j] !=  '.') {
                    rowElements.add(board[i][j] - '0');
                }
                if (board[j][i] != '.') {
                    columnElements.add(board[j][i] - '0');
                }
            }
            valid = validateSudokuLine(rowElements) && validateSudokuLine(columnElements);
            if (!valid) {
                return false; // invalid
            }
//            System.out.println("row column done ----");
            int r1,r2,c1,c2;
            for (int x = 0; x < 9 && valid; x++) {
                         // x  0 1 2 3 4 5 6 7 8
                r1 = x / 3; // 0 0 0 1 1 1 2 2 2
                c1 = x % 3; // 0 1 2 0 1 2 0 1 2
                r1 = r1 * 3; // 0 0 0 3 3 3 6 6 6
                c1 = c1 * 3; // 0 3 6 0 3 6 0 3 6
                valid = checkSudoku(r1, c1, r1 + 2, c1 + 2, board);
            }
        }
        return valid;
    }

    private boolean checkSudoku(int r1, int c1, int r2, int c2, char[][] board) {
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i =r1; i <= r2; i++) {
            for (int j = c1; j<= c2; j++) {
//                System.out.println("adding " + i + ", " + j);
                if (board[i][j] !=  '.') {
                    elements.add(board[i][j] - '0');
                }
            }
        }
        return validateSudokuLine(elements);
    }

    private boolean validateSudokuLine(ArrayList<Integer> line) {
        if (line == null || line.size() > 9) return false; // trivial case
        if (line.isEmpty()) return true;
//        StringBuilder sb = new StringBuilder();
//        for (Integer integer : line) {
//            sb.append(" ").append(integer);
//        }
//        System.out.println(sb.toString() + "----------------");
        int [] count = new int[9];
        for (int i = 0; i< line.size(); i++) {
            count[line.get(i)-1]++;
        }
        for (int i =0; i < 9; i++) {
            if (count[i] > 1) {
                return false;
            }
        }
        return true;
    }



    public char[][] stringToCharArray(String input){
//        String input = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],"
//                + "[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],"
//                + "[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],"
//                + "[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],"
//                + "[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],"
//                + "[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],"
//                + "[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],"
//                + "[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],"
//                + "[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";

        // Remove unwanted characters like brackets and quotes
        input = input.replace("[", "").replace("]", "").replace("\"", "");

        // Split the string into elements by commas
        String[] elements = input.split(",");

        // Create a 2D array
        char[][] board = new char[9][9];

        // Populate the 2D array
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = elements[index++].charAt(0);
            }
        }

        // Print the 2D array
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        return board;
    }

}
