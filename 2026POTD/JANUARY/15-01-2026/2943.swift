class Solution {
    func maximizeSquareHoleArea(_ n: Int, _ m: Int, _ hBars: [Int], _ vBars: [Int]) -> Int {
        func longest(_ a: [Int]) -> Int {
            let b = a.sorted()
            var best = 1, cur = 1
            for i in 1..<b.count {
                if b[i] == b[i - 1] + 1 {
                    cur += 1
                } else {
                    cur = 1
                }
                if cur > best {
                    best = cur
                }
            }
            return best + 1
        }

        let side = min(longest(hBars), longest(vBars))
        return side * side
    }
}