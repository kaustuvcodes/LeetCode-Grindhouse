class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            row[i] = '#';
        }
        row[0] = '.';
        String rowStr = new String(row);
        for (int i = 0; i < m - 1; i++) {
            grid[i] = rowStr;
        }
        char[] topRow = new char[n];
        for (int i = 0; i < n; i++) {
            topRow[i] = '.';
        }
        grid[m - 1] = new String(topRow);
        return grid;
    }
}