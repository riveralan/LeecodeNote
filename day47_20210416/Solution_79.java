package LeecodeNote.day47_20210416;

public class Solution_79 {
    /**
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     *
     * @param board
     * @param word
     * @return
     */
    //普通版
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int index, int i, int j, int m, int n) {
        if (checkOutside(i, j, m, n)) {
            return false;
        }
        if (index == word.length() - 1 && word.charAt(index) == board[i][j]) {
            return true;
        }
        char temp = board[i][j];

        if (word.charAt(index) == board[i][j]) {
            board[i][j] = '*';
            boolean result = exist(board, word, index + 1, i, j - 1, m, n)
                    || exist(board, word, index + 1, i, j + 1, m, n)
                    || exist(board, word, index + 1, i + 1, j, m, n)
                    || exist(board, word, index + 1, i - 1, j, m, n);
            board[i][j] = temp;
            return result;
        }
        return false;
    }

    private boolean checkOutside(int i, int j, int m, int n) {
        return !(i >= 0 && j >= 0 && i < m && j < n);
    }

    public static void main(String[] args) {
        Solution_79 test = new Solution_79();
        //[["C","A","A"],["A","A","A"],["B","C","D"]]
        //"AAB"
        boolean result = test.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB");
        System.out.println(result);
    }
}
