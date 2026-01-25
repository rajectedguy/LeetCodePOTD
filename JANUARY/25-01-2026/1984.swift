class Solution {
    func minimumDifference(_ nums: [Int], _ k: Int) -> Int {
        if k <= 1 { return 0 }
        let a = nums.sorted()
        var ans = Int.max
        for i in 0...a.count - k {
            ans = min(ans, a[i + k - 1] - a[i])
        }
        return ans
    }
}