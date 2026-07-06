class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
       int maxRight = Integer.MIN_VALUE;
        int kept = 0;

        for (int i = 0; i < intervals.length; i++) {
            int right = intervals[i][1];

            if (right > maxRight) {
                kept++;
                maxRight = right;
            }
        }

        return kept;
    }
}