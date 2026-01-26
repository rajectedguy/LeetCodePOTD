class Solution {
    func minimumAbsDifference(_ arr: [Int]) -> [[Int]] {
        let a = arr.sorted()
        var mn = Int.max
        for i in 1..<a.count {
            mn = min(mn, a[i] - a[i - 1])
        }
        var res = [[Int]]()
        for i in 1..<a.count {
            if a[i] - a[i - 1] == mn {
                res.append([a[i - 1], a[i]])
            }
        }
        return res
    }
}