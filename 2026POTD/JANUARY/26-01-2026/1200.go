func minimumAbsDifference(arr []int) [][]int {
    sort.Ints(arr)
    mn := math.MaxInt32
    for i := 1; i < len(arr); i++ {
        if arr[i]-arr[i-1] < mn {
            mn = arr[i] - arr[i-1]
        }
    }
    res := [][]int{}
    for i := 1; i < len(arr); i++ {
        if arr[i]-arr[i-1] == mn {
            res = append(res, []int{arr[i-1], arr[i]})
        }
    }
    return res
}