class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        int row = 0, dir = 0;

        for (int i = 0; i < s.length(); i++) {
            row += dir;

            if (sbs[row] == null) {
                sbs[row] = new StringBuilder();
            }
            sbs[row].append(s.charAt(i));

            if (row == 0) {
                dir = 1;
            } else if (row == numRows - 1) {
                dir = -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            if (sb != null) {
                result.append(sb);
            }
        }

        return result.toString();
    }
}