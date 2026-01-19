func largestSquareArea(bottomLeft [][]int, topRight [][]int) int64 {
	n := len(bottomLeft)
	var ans int64 = 0
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			x1 := bottomLeft[i][0]
			if bottomLeft[j][0] > x1 {
				x1 = bottomLeft[j][0]
			}
			y1 := bottomLeft[i][1]
			if bottomLeft[j][1] > y1 {
				y1 = bottomLeft[j][1]
			}
			x2 := topRight[i][0]
			if topRight[j][0] < x2 {
				x2 = topRight[j][0]
			}
			y2 := topRight[i][1]
			if topRight[j][1] < y2 {
				y2 = topRight[j][1]
			}
			if x2 > x1 && y2 > y1 {
				side := x2 - x1
				if y2-y1 < side {
					side = y2 - y1
				}
				area := int64(side) * int64(side)
				if area > ans {
					ans = area
				}
			}
		}
	}
	return ans
}