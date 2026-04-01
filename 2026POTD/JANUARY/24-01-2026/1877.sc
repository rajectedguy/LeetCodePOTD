object Solution {
    def minPairSum(nums: Array[Int]): Int = {
        scala.util.Sorting.quickSort(nums)
        var i = 0
        var j = nums.length - 1
        var ans = 0
        while (i < j) {
            ans = math.max(ans, nums(i) + nums(j))
            i += 1
            j -= 1
        }
        ans
    }
}