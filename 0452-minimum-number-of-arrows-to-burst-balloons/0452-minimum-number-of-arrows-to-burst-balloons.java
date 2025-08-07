class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        int result = 1;
        // sort all baloons
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // set second indx from array as starting point
        int end = points[0][1];
        // base on first idx of each array find intersections
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                result++;
                end = points[i][1];
            }
        }

        return result;
    }
}