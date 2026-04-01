class Solution {
public:
    int maximizeSquareArea(int m, int n, vector<int>& hFences, vector<int>& vFences) {
        const long long MOD = 1000000007;
        
        hFences.push_back(1);
        hFences.push_back(m);
        vFences.push_back(1);
        vFences.push_back(n);
        
        sort(hFences.begin(), hFences.end());
        sort(vFences.begin(), vFences.end());
        
        unordered_set<long long> hs;
        for (int i = 0; i < hFences.size(); i++)
            for (int j = i + 1; j < hFences.size(); j++)
                hs.insert((long long)hFences[j] - hFences[i]);
        
        long long best = -1;
        for (int i = 0; i < vFences.size(); i++) {
            for (int j = i + 1; j < vFences.size(); j++) {
                long long d = (long long)vFences[j] - vFences[i];
                if (hs.count(d)) best = max(best, d);
            }
        }
        
        if (best == -1) return -1;
        return (best % MOD) * (best % MOD) % MOD;
    }
};