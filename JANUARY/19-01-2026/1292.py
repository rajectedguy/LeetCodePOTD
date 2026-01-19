from typing import List

class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])

        prefix = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m):
            for j in range(n):
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]

        left, right, ans = 0, min(m, n), 0
        while left <= right:
            mid = (left + right) // 2
            found = False
            for i in range(mid, m + 1):
                for j in range(mid, n + 1):
                    total = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid]
                    if total <= threshold:
                        found = True
                        break
                if found:
                    break
            if found:
                ans = mid
                left = mid + 1
            else:
                right = mid - 1
        return ans