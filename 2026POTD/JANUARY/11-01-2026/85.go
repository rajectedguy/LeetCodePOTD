func maximalRectangle(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}

	cols := len(matrix[0])
	heights := make([]int, cols)
	ans := 0

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < cols; j++ {
			if matrix[i][j] == '1' {
				heights[j]++
			} else {
				heights[j] = 0
			}
		}

		stack := []int{}
		for k := 0; k <= cols; k++ {
			h := 0
			if k < cols {
				h = heights[k]
			}
			for len(stack) > 0 && h < heights[stack[len(stack)-1]] {
				height := heights[stack[len(stack)-1]]
				stack = stack[:len(stack)-1]
				width := k
				if len(stack) > 0 {
					width = k - stack[len(stack)-1] - 1
				}
				area := height * width
				if area > ans {
					ans = area
				}
			}
			stack = append(stack, k)
		}
	}

	return ans
}