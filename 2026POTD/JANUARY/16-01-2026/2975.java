import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1000000007L;
        
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];
        
        h[0] = 1;
        h[1] = m;
        v[0] = 1;
        v[1] = n;
        
        System.arraycopy(hFences, 0, h, 2, hFences.length);
        System.arraycopy(vFences, 0, v, 2, vFences.length);
        
        Arrays.sort(h);
        Arrays.sort(v);
        
        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < h.length; i++)
            for (int j = i + 1; j < h.length; j++)
                hs.add((long) h[j] - h[i]);
        
        long best = -1;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                long d = (long) v[j] - v[i];
                if (hs.contains(d)) best = Math.max(best, d);
            }
        }
        
        if (best == -1) return -1;
        return (int) ((best % MOD) * (best % MOD) % MOD);
    }
}