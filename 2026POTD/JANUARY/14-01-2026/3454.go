func separateSquares(squares [][]int) float64 {
	n := len(squares)

	xs := make([]int64, 0, 2*n)
	type Event struct {
		y, x1, x2 int64
		t         int64
	}
	events := make([]Event, 0, 2*n)

	for _, s := range squares {
		x, y, l := int64(s[0]), int64(s[1]), int64(s[2])
		xs = append(xs, x, x+l)
		events = append(events,
			Event{y, x, x + l, 1},
			Event{y + l, x, x + l, -1},
		)
	}

	sort.Slice(xs, func(i, j int) bool { return xs[i] < xs[j] })
	uniq := xs[:0]
	for _, v := range xs {
		if len(uniq) == 0 || uniq[len(uniq)-1] != v {
			uniq = append(uniq, v)
		}
	}
	xs = uniq
	m := len(xs)

	idx := make(map[int64]int, m)
	for i, v := range xs {
		idx[v] = i
	}

	cnt := make([]int64, 4*m)
	seglen := make([]int64, 4*m)

	var upd func(i, l, r, ql, qr int, v int64)
	upd = func(i, l, r, ql, qr int, v int64) {
		if qr <= l || r <= ql {
			return
		}
		if ql <= l && r <= qr {
			cnt[i] += v
		} else {
			mid := (l + r) >> 1
			upd(i<<1, l, mid, ql, qr, v)
			upd(i<<1|1, mid, r, ql, qr, v)
		}
		if cnt[i] > 0 {
			seglen[i] = xs[r] - xs[l]
		} else if l+1 == r {
			seglen[i] = 0
		} else {
			seglen[i] = seglen[i<<1] + seglen[i<<1|1]
		}
	}

	sort.Slice(events, func(i, j int) bool { return events[i].y < events[j].y })

	prev := events[0].y
	total := float64(0)
	i := 0

	for i < len(events) {
		y := events[i].y
		dy := y - prev
		if dy > 0 && seglen[1] > 0 {
			total += float64(seglen[1]) * float64(dy)
		}
		for i < len(events) && events[i].y == y {
			upd(1, 0, m, idx[events[i].x1], idx[events[i].x2], events[i].t)
			i++
		}
		prev = y
	}

	half := total / 2.0
	cnt = make([]int64, 4*m)
	seglen = make([]int64, 4*m)

	prev = events[0].y
	cur := float64(0)
	i = 0

	for i < len(events) {
		y := events[i].y
		dy := y - prev
		if dy > 0 && seglen[1] > 0 {
			area := float64(seglen[1]) * float64(dy)
			if cur+area >= half {
				return float64(prev) + (half-cur)/float64(seglen[1])
			}
			cur += area
		}
		for i < len(events) && events[i].y == y {
			upd(1, 0, m, idx[events[i].x1], idx[events[i].x2], events[i].t)
			i++
		}
		prev = y
	}

	return float64(prev)
}