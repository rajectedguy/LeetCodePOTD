class Solution:
    def reverseBits(self, n: int) -> int:
        bit = bin(n)
        exclude = bit[2:]
        toAdd = 32 - len(exclude)
        newStr = f"{"0" * toAdd}{exclude}"
        reverse = newStr[::-1]
        return int(reverse, 2)