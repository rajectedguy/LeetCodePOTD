class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        from collections import deque

        q = deque([root])
        level = 1
        ans = 1
        max_sum = float('-inf')

        while q:
            size = len(q)
            s = 0
            for _ in range(size):
                node = q.popleft()
                s += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if s > max_sum:
                max_sum = s
                ans = level
            level += 1

        return ans