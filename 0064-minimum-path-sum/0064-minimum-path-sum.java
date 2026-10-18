class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return min(0, 0, grid, dp);
    }

    int min(int x, int y , int[][] grid, int[][] dp) {
        if (x >= grid.length || y >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        return dp[x][y] = grid[x][y] + Math.min(min(x + 1, y, grid, dp),
                min(x, y + 1, grid, dp));
    }
}