using System;
using System.Collections.Generic;

public class Solution {
    public int MaximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        const long MOD = 1000000007L;

        int[] h = new int[hFences.Length + 2];
        int[] v = new int[vFences.Length + 2];

        h[0] = 1;
        h[1] = m;
        v[0] = 1;
        v[1] = n;

        Array.Copy(hFences, 0, h, 2, hFences.Length);
        Array.Copy(vFences, 0, v, 2, vFences.Length);

        Array.Sort(h);
        Array.Sort(v);

        HashSet<long> hs = new HashSet<long>();
        for (int i = 0; i < h.Length; i++)
            for (int j = i + 1; j < h.Length; j++)
                hs.Add((long)h[j] - h[i]);

        long best = -1;
        for (int i = 0; i < v.Length; i++) {
            for (int j = i + 1; j < v.Length; j++) {
                long d = (long)v[j] - v[i];
                if (hs.Contains(d)) best = Math.Max(best, d);
            }
        }

        if (best == -1) return -1;
        return (int)((best % MOD) * (best % MOD) % MOD);
    }
}