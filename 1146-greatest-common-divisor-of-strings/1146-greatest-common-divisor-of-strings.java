class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int l1 = str1.length();
        int l2 = str2.length();
        int end = gsd(l1, l2);

        return str1.substring(0, end);
    }

    private int gsd(int l1, int l2) {
        if (l1 == 0) {
            return l2;
        }
        if (l2 == 0) {
            return l1;
        }

        return gsd(l2, l1 % l2);
    }
}
