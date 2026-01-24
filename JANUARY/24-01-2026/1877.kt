class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var i = 0
        var j = nums.size - 1
        var ans = 0
        while (i < j) {
            ans = maxOf(ans, nums[i] + nums[j])
            i++
            j--
        }
        return ans
    }
}