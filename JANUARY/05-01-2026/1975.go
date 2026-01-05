func maxMatrixSum(matrix [][]int) int64 {
    var sum int64 = 0
    neg := 0
    mn := int64(1<<63 - 1)
    for _, row := range matrix {
        for _, x := range row {
            if x < 0 {
                neg++
            }
            ax := int64(x)
            if ax < 0 {
                ax = -ax
            }
            sum += ax
            if ax < mn {
                mn = ax
            }
        }
    }
    if neg%2 == 1 {
        sum -= 2 * mn
    }
    return sum
}