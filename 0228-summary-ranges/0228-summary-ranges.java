class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        int min = nums[0];
        int max = min;

        for (int i = 1; i < nums.length; i++) {
            if (max + 1 == nums[i]) {
                max = nums[i];
                continue;
            }
            if (min == max) {
                list.add(min + "");
            } else {
                list.add(min + "->" + max);
            }
            min = nums[i];
            max = nums[i];
        }

        if (min == max) {
            list.add(min + "");
        } else {
            list.add(min + "->" + max);
        }

        return list;
    }
}