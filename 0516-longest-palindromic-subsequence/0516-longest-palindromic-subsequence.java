class Solution {
    public int longestPalindromeSubseq(String s) {
        //   b b b a b
        // b 1 2 3 3 4
        // b 0 1 2 2 3
        // b 0 0 1 1 3
        // a 0 0 0 1 1
        // b 0 0 0 0 1

        // b b b a b

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                // If characters are matched adding 2 to inner subsequence
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}