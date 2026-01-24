func minPairSum(nums []int) int {
    sort.Ints(nums)
    i, j, ans := 0, len(nums)-1, 0
    for i < j {
        s := nums[i] + nums[j]
        if s > ans {
            ans = s
        }
        i++
        j--
    }
    return ans
}