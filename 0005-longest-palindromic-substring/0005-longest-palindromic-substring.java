class Solution {
    public String longestPalindrome(String s) {
        if (s == null && s.length() < 2) return s;
        // create two variables that wil hold left and right pointers of max palindrom
        int start = 0;
        int end = 0;

        // iterate through string and look for longest palindrom
        for (int i = 0; i < s.length(); i++) {
            // on each point of iteration we need to check longest valide palindrom
            // we need to check two conditions when palindrom have odd length and even length
            // odd
            int len1 = helper(s, i, i);
            // even
            int len2 = helper(s, i, i + 1);  
            // after we found longest palindrom we need to update current max length
            int maxLen = Math.max(len1, len2);

            // and check if current max length of palindrom is biger then we hold in left and right variables
            // if biger update left and right
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        // substring using left and right pointers 
        return s.substring(start, end + 1);
    }

    private int helper(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}