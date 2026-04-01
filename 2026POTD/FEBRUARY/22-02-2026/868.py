class Solution:
    def binaryGap(self, n: int) -> int:
        last = -1
        pos = 0
        gap = 0
        while n>0:
            if n & 1 == 1:
                if last != -1:
                    gap = max(gap, pos-last)
                last = pos
            n >>= 1
            pos += 1
        return gap