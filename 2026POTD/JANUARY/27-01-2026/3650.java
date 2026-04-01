class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        List<int[]>[] in = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            in[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d != dist[u]) continue;
            if (u == n - 1) return (int) d;

            for (int[] e : g[u]) {
                if (dist[e[0]] > d + e[1]) {
                    dist[e[0]] = d + e[1];
                    pq.offer(new long[]{dist[e[0]], e[0]});
                }
            }
            for (int[] e : in[u]) {
                if (dist[e[0]] > d + 2L * e[1]) {
                    dist[e[0]] = d + 2L * e[1];
                    pq.offer(new long[]{dist[e[0]], e[0]});
                }
            }
        }
        return -1;
    }
}