class Solution:
    def minOperations(self, s: str) -> int:
        diff = 0

        for i in range(len(s)):
            if s[i] != ("1" if i % 2 == 0 else '0'):
                diff += 1

        return min(diff, len(s) - diff)