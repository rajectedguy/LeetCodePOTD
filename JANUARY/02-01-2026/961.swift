class Solution {
    func repeatedNTimes(_ nums: [Int]) -> Int {
        var set = Set<Int>()
        for x in nums {
            if set.contains(x) { return x }
            set.insert(x)
        }
        return -1
    }
}