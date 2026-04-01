class Solution(object):
    def maximizeSquareHoleArea(self, n, m, hBars, vBars):
        def longest(a):
            a.sort()
            best = cur = 1
            for i in range(1, len(a)):
                if a[i] == a[i - 1] + 1:
                    cur += 1
                else:
                    cur = 1
                if cur > best:
                    best = cur
            return best + 1

        side = min(longest(hBars), longest(vBars))
        return side * side