class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                }
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }

        return result * result;
    }
}