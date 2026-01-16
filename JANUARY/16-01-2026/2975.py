class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        MOD = 10**9 + 7
        
        h = hFences + [1, m]
        v = vFences + [1, n]
        
        h.sort()
        v.sort()
        
        hs = set()
        for i in range(len(h)):
            for j in range(i + 1, len(h)):
                hs.add(h[j] - h[i])
        
        best = -1
        for i in range(len(v)):
            for j in range(i + 1, len(v)):
                d = v[j] - v[i]
                if d in hs:
                    best = max(best, d)
        
        if best == -1:
            return -1
        return (best * best) % MOD