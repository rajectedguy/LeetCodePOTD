class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total = 0
        neg = 0
        mn = float('inf')
        for row in matrix:
            for x in row:
                if x < 0:
                    neg += 1
                total += abs(x)
                mn = min(mn, abs(x))
        if neg % 2:
            total -= 2 * mn
        return total