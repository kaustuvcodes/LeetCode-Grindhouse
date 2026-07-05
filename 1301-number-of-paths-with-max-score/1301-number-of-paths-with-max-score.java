class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] cost = new int[n][n];
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(cost[i], -1);
        cost[0][0] = 0;
        path[0][0] = 1;
        int[][] dir = { { -1, 0 }, { -1, -1 }, { 0, -1 } };
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                char c = board.get(i).charAt(j);
                if (c == 'E' || c == 'X')
                    continue;
                int max = -1;
                int cnt = 0;
                for (int[] d : dir) {
                    int newi = i + d[0];
                    int newj = j + d[1];
                    if (newi < 0 || newj < 0 || board.get(newi).charAt(newj) == 'X' || path[newi][newj] == 0)
                        continue;
                    if (cost[newi][newj] > max) {
                        max = cost[newi][newj];
                        cnt = path[newi][newj];
                    } else if (max == cost[newi][newj])
                        cnt = (cnt + path[newi][newj]) % 1000000007;
                }
                if (cnt == 0)
                    continue;
                int p;
                if (c == 'S')
                    p = 0;
                else
                    p = c - '0';
                cost[i][j] = max + p;
                path[i][j] = cnt;
            }
        if (path[n - 1][n - 1] == 0)
            return new int[] { 0, 0 };
        return new int[] { cost[n - 1][n - 1], path[n - 1][n - 1] };
    }
}