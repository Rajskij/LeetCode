class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int end = gsd(str1.length(), str2.length());

        return str1.substring(0, end);
    }

    private int gsd(int l1, int l2) {
        while (l2 != 0) {
            int tmp = l2;
            l2 = l1 % l2;
            l1 = tmp;
        }    
        return l1;
    }
}
