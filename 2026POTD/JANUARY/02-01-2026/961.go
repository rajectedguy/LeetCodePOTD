func repeatedNTimes(nums []int) int {
    seen := make(map[int]bool)
    for _, x := range nums {
        if seen[x] {
            return x
        }
        seen[x] = true
    }
    return -1
}