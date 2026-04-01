function maximizeSquareArea(m: number, n: number, hFences: number[], vFences: number[]): number {
    const MOD = 1000000007n;

    const h = [...hFences, 1, m].sort((a, b) => a - b);
    const v = [...vFences, 1, n].sort((a, b) => a - b);

    const hs = new Set<bigint>();
    for (let i = 0; i < h.length; i++) {
        for (let j = i + 1; j < h.length; j++) {
            hs.add(BigInt(h[j] - h[i]));
        }
    }

    let best = -1n;
    for (let i = 0; i < v.length; i++) {
        for (let j = i + 1; j < v.length; j++) {
            const d = BigInt(v[j] - v[i]);
            if (hs.has(d) && d > best) best = d;
        }
    }

    if (best === -1n) return -1;
    return Number((best * best) % MOD);
}