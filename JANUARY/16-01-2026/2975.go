func maximizeSquareArea(m int, n int, hFences []int, vFences []int) int {
	const MOD int64 = 1000000007

	h := make([]int, 0, len(hFences)+2)
	v := make([]int, 0, len(vFences)+2)

	h = append(h, 1, m)
	h = append(h, hFences...)
	v = append(v, 1, n)
	v = append(v, vFences...)

	sort.Ints(h)
	sort.Ints(v)

	hs := make(map[int]struct{})
	for i := 0; i < len(h); i++ {
		for j := i + 1; j < len(h); j++ {
			hs[h[j]-h[i]] = struct{}{}
		}
	}

	best := -1
	for i := 0; i < len(v); i++ {
		for j := i + 1; j < len(v); j++ {
			d := v[j] - v[i]
			if _, ok := hs[d]; ok && d > best {
				best = d
			}
		}
	}

	if best == -1 {
		return -1
	}
	return int((int64(best) * int64(best)) % MOD)
}