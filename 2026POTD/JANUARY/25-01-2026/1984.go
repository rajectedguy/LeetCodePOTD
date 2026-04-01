func minimumDifference(nums []int, k int) int {
    if k <= 1 {
        return 0
    }
    sort.Ints(nums)
    ans := math.MaxInt32
    for i := 0; i+k-1 < len(nums); i++ {
        if nums[i+k-1]-nums[i] < ans {
            ans = nums[i+k-1] - nums[i]
        }
    }
    return ans
}