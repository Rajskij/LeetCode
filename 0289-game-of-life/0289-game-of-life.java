// Case for alive
// if less 2 neighbors - dies
// if more then 3 - dies
// if 2 or 3 neighbors - lives

// Case for dead sell
// if exactly 3 neighbors - become live if not

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                updateCurrentCell(board, i, j, n, m);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void updateCurrentCell(int[][] board, int i, int j, int n, int m) {
        // Possible neighbors directions
        int[] directions = { -1, 0, 1 };
        // To count all live neighbors
        int liveNeighbors = 0;

        for (int y : directions) {
            for (int x : directions) {
                // Skip the cell itself
                if (y == 0 && x == 0) {
                    continue;
                }
                int ny = y + i;
                int nx = x + j;

                // To stay in matrix boundaries
                if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    if (board[ny][nx] == 1 || board[ny][nx] == -1) {
                        liveNeighbors++;
                    }
                }
            }
        }

        if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
            board[i][j] = -1;
        }
        if (board[i][j] == 0 && liveNeighbors == 3) {
            board[i][j] = 2;
        }
    }
}
