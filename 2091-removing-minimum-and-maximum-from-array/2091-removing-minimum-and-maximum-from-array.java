class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);
        int bothFront = right + 1;
        int bothBack = n - left;
        int split = (left + 1) + (n - right);
        return Math.min(bothFront, Math.min(bothBack, split));
    }
}


    