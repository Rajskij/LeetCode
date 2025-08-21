class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // a b c d e
        // a c e

        //     a b c d e
        //     0 0 0 0 0
        // a 0 1 1 1 1 1
        // c 0 1 1 2 2 2
        // e 0 1 1 2 2 3

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If current char match, extend previous diagonal + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}