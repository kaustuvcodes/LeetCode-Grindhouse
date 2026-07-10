class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // Pack (value,index) into one long to avoid int[][] allocations
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = ((long) nums[i] << 32) | i;

        Arrays.sort(a);

        int[] pos = new int[n];
        int[] root = new int[n];

        for (int i = 0; i < n; i++)
            pos[(int) a[i]] = i;

        for (int i = 1; i < n; i++) {
            if ((int) (a[i] >> 32) - (int) (a[i - 1] >> 32) <= maxDiff)
                root[i] = root[i - 1];
            else
                root[i] = i;
        }

        int[] next = new int[n];

        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && (int) (a[r] >> 32) - (int) (a[l] >> 32) <= maxDiff)
                r++;
            next[l] = r - 1;
        }

        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] up = new int[LOG][n];

        System.arraycopy(next, 0, up[0], 0, n);

        for (int b = 1; b < LOG; b++)
            for (int i = 0; i < n; i++)
                up[b][i] = up[b - 1][up[b - 1][i]];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (root[u] != root[v]) {
                ans[i] = -1;
                continue;
            }

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            int step = 0;

            for (int b = LOG - 1; b >= 0; b--) {
                if (up[b][u] < v) {
                    step += 1 << b;
                    u = up[b][u];
                }
            }

            ans[i] = u == v ? step : step + 1;
        }

        return ans;
    }
}