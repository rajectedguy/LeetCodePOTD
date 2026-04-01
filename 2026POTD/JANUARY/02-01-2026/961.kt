class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (x in nums) {
            if (!set.add(x)) return x
        }
        return -1
    }
}