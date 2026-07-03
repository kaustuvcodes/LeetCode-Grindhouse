import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int maxDist = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (online[u] && online[v]) {
                adj.get(u).add(new int[] { v, wt });
                maxDist = Math.max(maxDist, wt);
            }
        }

        long low = 0;
        long high = maxDist;
        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (dijkstra(mid, adj, n, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean dijkstra(long mid, List<List<int[]>> adj, int n, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                Comparator.comparingLong(a -> a[0]));

        dist[0] = 0;
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long distance = cur[0];
            int node = (int) cur[1];

            if (distance > dist[node])
                continue;

            if (node == n - 1)
                return true;

            for (int[] edge : adj.get(node)) {
                int v = edge[0];
                int w = edge[1];

                if (w < mid)
                    continue;

                long newDist = distance + w;

                if (newDist > k)
                    continue;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new long[] { newDist, v });
                }
            }
        }
        return false;
    }
}