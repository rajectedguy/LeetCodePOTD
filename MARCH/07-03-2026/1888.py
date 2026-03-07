class Solution:
    def minFlips(self, s: str) -> int:
        odd = deque([int(s[i]) for i in range(1, len(s), 2)])
        even = deque([int(s[i]) for i in range(0, len(s), 2)])
        oddCount = [odd.count(0), odd.count(1)]
        evenCount = [even.count(0), even.count(1)]
        res = min(
            oddCount[0] + evenCount[1],
            oddCount[1] + evenCount[0],
        )
        if len(s) % 2 == 0:
            return res
        for _ in range(len(s)):
            odd, even = even, odd
            oddCount, evenCount = evenCount, oddCount
            even.append(odd.popleft())
            n = 0 if even[-1] == 0 else 1
            oddCount[n] -= 1
            evenCount[n] += 1
            res = min(
                res,
                oddCount[0] + evenCount[1],
                oddCount[1] + evenCount[0],
            )
        return res