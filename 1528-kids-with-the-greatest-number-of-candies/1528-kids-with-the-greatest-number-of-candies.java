class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxVal = 0;

        for (int i : candies) {
            if (maxVal < i) {
                maxVal = i;
            }
        }

        for (int i : candies) {
            if (i + extraCandies >= maxVal) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }
}