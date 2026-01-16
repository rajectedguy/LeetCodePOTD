/**
 * @param {number} m
 * @param {number} n
 * @param {number[]} hFences
 * @param {number[]} vFences
 * @return {number}
 */
var maximizeSquareArea = function(m, n, hFences, vFences) {
    const MOD = 1000000007n;
    
    let h = hFences.concat([1, m]).sort((a, b) => a - b);
    let v = vFences.concat([1, n]).sort((a, b) => a - b);
    
    let hs = new Set();
    for (let i = 0; i < h.length; i++) {
        for (let j = i + 1; j < h.length; j++) {
            hs.add(BigInt(h[j] - h[i]));
        }
    }
    
    let best = -1n;
    for (let i = 0; i < v.length; i++) {
        for (let j = i + 1; j < v.length; j++) {
            let d = BigInt(v[j] - v[i]);
            if (hs.has(d) && d > best) best = d;
        }
    }
    
    if (best === -1n) return -1;
    return Number((best * best) % MOD);
};