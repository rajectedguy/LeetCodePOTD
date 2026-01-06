class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        val q: ArrayDeque<TreeNode> = ArrayDeque()
        q.add(root!!)
        var level = 1
        var ans = 1
        var maxSum = Long.MIN_VALUE

        while (q.isNotEmpty()) {
            val size = q.size
            var sum = 0L

            repeat(size) {
                val node = q.removeFirst()
                sum += node.`val`
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }

            if (sum > maxSum) {
                maxSum = sum
                ans = level
            }
            level++
        }
        return ans
    }
}