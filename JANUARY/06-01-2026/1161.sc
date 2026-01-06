object Solution {
    def maxLevelSum(root: TreeNode): Int = {
        import scala.collection.mutable.Queue
        val q = Queue[TreeNode](root)
        var level = 1
        var ans = 1
        var maxSum = Long.MinValue

        while (q.nonEmpty) {
            val size = q.size
            var sum = 0L

            for (_ <- 0 until size) {
                val node = q.dequeue()
                sum += node.value
                if (node.left != null) q.enqueue(node.left)
                if (node.right != null) q.enqueue(node.right)
            }

            if (sum > maxSum) {
                maxSum = sum
                ans = level
            }
            level += 1
        }
        ans
    }
}