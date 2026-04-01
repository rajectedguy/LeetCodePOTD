import "sort"

func maximizeSquareHoleArea(n int, m int, hBars []int, vBars []int) int {
    longest := func(a []int) int {
        sort.Ints(a)
        best, cur := 1, 1
        for i := 1; i < len(a); i++ {
            if a[i] == a[i-1]+1 {
                cur++
            } else {
                cur = 1
            }
            if cur > best {
                best = cur
            }
        }
        return best + 1
    }

    h := longest(hBars)
    v := longest(vBars)
    if h < v {
        return h * h
    }
    return v * v
}