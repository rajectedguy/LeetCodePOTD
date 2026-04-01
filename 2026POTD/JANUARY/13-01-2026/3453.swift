class Solution {
    func separateSquares(_ squares: [[Int]]) -> Double {
        var lo = 1e18
        var hi = -1e18
        var total = 0.0

        for s in squares {
            let y = Double(s[1])
            let l = Double(s[2])
            if y < lo { lo = y }
            if y + l > hi { hi = y + l }
            total += l * l
        }

        let target = total / 2.0

        for _ in 0..<80 {
            let mid = (lo + hi) * 0.5
            var below = 0.0
            for s in squares {
                let y = Double(s[1])
                let l = Double(s[2])
                if mid > y {
                    let h = min(mid - y, l)
                    below += h * l
                }
            }
            if below < target {
                lo = mid
            } else {
                hi = mid
            }
        }

        return lo
    }
}