class Solution {
    func maximizeSquareArea(_ m: Int, _ n: Int, _ hFences: [Int], _ vFences: [Int]) -> Int {
        let MOD: Int64 = 1_000_000_007

        var h = hFences
        var v = vFences
        h.append(1)
        h.append(m)
        v.append(1)
        v.append(n)

        h.sort()
        v.sort()

        var hs = Set<Int>()
        for i in 0..<h.count {
            for j in (i + 1)..<h.count {
                hs.insert(h[j] - h[i])
            }
        }

        var best = -1
        for i in 0..<v.count {
            for j in (i + 1)..<v.count {
                let d = v[j] - v[i]
                if hs.contains(d) {
                    best = max(best, d)
                }
            }
        }

        if best == -1 { return -1 }
        return Int((Int64(best) * Int64(best)) % MOD)
    }
}