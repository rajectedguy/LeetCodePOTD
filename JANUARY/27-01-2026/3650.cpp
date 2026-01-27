class Solution {
public:
    int minCost(int n, vector<vector<int>>& edges) {
        vector<vector<pair<int,int>>> g(n), in(n);
        for (auto &e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            in[e[1]].push_back({e[0], e[2]});
        }

        const long long INF = 1e18;
        vector<long long> dist(n, INF);
        priority_queue<pair<long long,int>, vector<pair<long long,int>>, greater<>> pq;

        dist[0] = 0;
        pq.push({0, 0});

        while (!pq.empty()) {
            auto [d, u] = pq.top(); pq.pop();
            if (d != dist[u]) continue;
            if (u == n - 1) return d;

            for (auto &[v, w] : g[u]) {
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.push({dist[v], v});
                }
            }

            for (auto &[v, w] : in[u]) {
                if (dist[v] > d + 2LL * w) {
                    dist[v] = d + 2LL * w;
                    pq.push({dist[v], v});
                }
            }
        }

        return -1;
    }
};