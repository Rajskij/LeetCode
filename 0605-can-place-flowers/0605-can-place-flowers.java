class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int i = 0;

        while (i < len && n > 0) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                i += 2;
                n--;
            } else {
                i += 3;
            }
        }

        return n <= 0;
    }
}