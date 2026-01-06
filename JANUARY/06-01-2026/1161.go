func maxLevelSum(root *TreeNode) int {
    q := []*TreeNode{root}
    level, ans := 1, 1
    maxSum := -1 << 60

    for len(q) > 0 {
        size := len(q)
        sum := 0

        for i := 0; i < size; i++ {
            node := q[0]
            q = q[1:]
            sum += node.Val
            if node.Left != nil {
                q = append(q, node.Left)
            }
            if node.Right != nil {
                q = append(q, node.Right)
            }
        }

        if sum > maxSum {
            maxSum = sum
            ans = level
        }
        level++
    }
    return ans
}