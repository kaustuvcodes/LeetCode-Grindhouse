class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] sq = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sq);
        long sum = 0;
        int mid = nums.length / 2;
        for (int i = 0; i < mid; i++) {
            sum -= sq[i];
        }
        for (int i = mid; i < nums.length; i++) {
            sum += sq[i];
        }
        return sum;
    }
}