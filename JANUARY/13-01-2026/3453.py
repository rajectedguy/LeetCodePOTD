class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        lo, hi = 1e18, -1e18
        total = 0.0
        for _, y, l in squares:
            lo = min(lo, y)
            hi = max(hi, y + l)
            total += l * l
        target = total / 2.0
        for _ in range(80):
            mid = (lo + hi) / 2.0
            below = 0.0
            for _, y, l in squares:
                if mid <= y:
                    continue
                h = min(mid - y, l)
                below += h * l
            if below < target:
                lo = mid
            else:
                hi = mid
        return lo