class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return totalPaths(0, 0, dp);
    }

    int totalPaths(int x, int y, int[][] dp) {
        if (x == dp.length - 1 && y == dp[0].length - 1) {
            return 1;
        }

        if (x >= dp.length || y >= dp[0].length) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        return dp[x][y] = totalPaths(x+1, y, dp) + totalPaths(x, y+1, dp);
    }
}