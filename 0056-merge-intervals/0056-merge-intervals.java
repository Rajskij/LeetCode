class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];

        for (int[] interval : intervals) {
            if (current[1] >= interval[0]) {
                // Overlap, then merge
                current[1] = Math.max(current[1], interval[1]); 
            } else {
                // No overlap
                list.add(current);
                current = interval;
            }
        }
        // add last interval
        list.add(current);

        return list.toArray(new int[list.size()][2]);
    }
}