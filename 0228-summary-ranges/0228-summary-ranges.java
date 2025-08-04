class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            int j = i;
            while (j < nums.length - 1 && nums[j] == nums[j + 1] - 1) {
                j++;
            }
            if (i < j) {
                sb.append("->").append(nums[j]);
            }
            i = j;
            list.add(sb.toString());
            sb = new StringBuilder();
        }

        return list;
    }
}