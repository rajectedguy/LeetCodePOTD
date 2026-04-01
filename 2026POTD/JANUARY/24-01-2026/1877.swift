class Solution {
    func minPairSum(_ nums: [Int]) -> Int {
        let a = nums.sorted()
        var i = 0, j = a.count - 1, ans = 0
        while i < j {
            ans = max(ans, a[i] + a[j])
            i += 1
            j -= 1
        }
        return ans
    }
}