class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = isFullWord(board, word, i, j, 0);
                }
                if (result == true) {
                    return result;
                }
            }
        }

        return result;
    }

    private boolean isFullWord(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(k)) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';

        boolean result = isFullWord(board, word, i + 1, j, k + 1) ||
                         isFullWord(board, word, i, j + 1, k + 1) ||
                         isFullWord(board, word, i - 1, j, k + 1) ||
                         isFullWord(board, word, i, j - 1, k + 1);

        board[i][j] = tmp;

        return result;
    }
}