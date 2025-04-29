class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxVal = 0;

        for (int i : candies) {
            maxVal = Math.max(maxVal, i);
        }

        for (int i : candies) {
            list.add(i + extraCandies >= maxVal);
        }

        return list;
    }
}