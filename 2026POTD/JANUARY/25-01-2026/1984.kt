class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        nums.sort()
        var ans = Int.MAX_VALUE
        for (i in 0..nums.size - k) {
            ans = minOf(ans, nums[i + k - 1] - nums[i])
        }
        return ans
    }
}