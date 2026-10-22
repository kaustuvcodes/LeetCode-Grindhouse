class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        boolean asc = true;
        boolean dsc = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] != (nums[i - 1] + 1) % n)
                asc = false;
            if (nums[i] != (nums[i - 1] - 1 + n) % n)
                dsc = false;
        }

        int ans = Integer.MAX_VALUE;

        if (asc) {
            int s = nums[0];
            int a = (n - s) % n;
            int b = s % n + 2;
            ans = Math.min(ans, Math.min(a, b));
        }

        if (dsc) {
            int d = nums[0];
            int t = (d + 1) % n;
            int a = 1 + (n - t) % n;
            int b = t + 1;
            ans = Math.min(ans, Math.min(a, b));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}