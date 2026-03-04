class Solution:
    def findKthBit(self, n: int, k: int) -> str:

        invert = 0

        l = 1

        for _ in range(1, n):
            l = l * 2 + 1

        init = "0"

        while l > 1:

            half = l // 2
            if half + 1 == k:
                init = "1"
                break
            elif k > half + 1:
                invert += 1
                k = l + 1 - k

            l = half

        if invert % 2 != 0:
            if init == "0":
                init = "1"
            else:
                init = "0"

        return init