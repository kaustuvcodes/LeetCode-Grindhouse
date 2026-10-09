class Solution {
    int[][] ans;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ans = new int[n][m];
        for(int[] rows : ans){
            Arrays.fill(rows , -1);
        }
        return solve(grid , n - 1 , m - 1);
    }
    public int solve(int[][] grid , int i , int j){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[0][0];
        if(ans[i][j] != -1) return ans[i][j];
        int up = solve(grid , i - 1 , j);
        int left = solve(grid , i , j - 1);
        ans[i][j] = grid[i][j] + Math.min(up ,left);
        return ans[i][j];
    }
}