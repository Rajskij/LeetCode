class Solution {
    public boolean validPalindrome(String s) {
        // We will iterate through string using two pointers
        // if we reach senter of the string and every caharater from left and right are matched return true
        // Check if skiping one char left or right returning valid palindrom

        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;

            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrom(s, i + 1, j) || isPalindrom(s, i, j - 1);
            }
        }

        return true;
    }

    private boolean isPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}