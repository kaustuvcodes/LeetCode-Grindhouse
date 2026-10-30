class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        char[] lbl = labels.toCharArray();
        pq.offer(new int[]{0, 0, 1});
        dist[0][1] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1], cnt = curr[2];
            if (u == n - 1) return d;
            if (d > dist[u][cnt]) continue;
            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1];
                int nextCnt = (lbl[u] == lbl[v]) ? cnt + 1 : 1;
                if (nextCnt <= k && d + w < dist[v][nextCnt]) {
                    dist[v][nextCnt] = d + w;
                    pq.offer(new int[]{dist[v][nextCnt], v, nextCnt});
                }
            }
        }
        return -1;
    }
}