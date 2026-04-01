func separateSquares(squares [][]int) float64 {
    lo, hi := 1e18, -1e18
    total := 0.0
    for _, s := range squares {
        y := float64(s[1])
        l := float64(s[2])
        if y < lo {
            lo = y
        }
        if y+l > hi {
            hi = y + l
        }
        total += l * l
    }
    target := total / 2.0
    for i := 0; i < 80; i++ {
        mid := (lo + hi) * 0.5
        below := 0.0
        for _, s := range squares {
            y := float64(s[1])
            l := float64(s[2])
            if mid > y {
                h := mid - y
                if h > l {
                    h = l
                }
                below += h * l
            }
        }
        if below < target {
            lo = mid
        } else {
            hi = mid
        }
    }
    return lo
}