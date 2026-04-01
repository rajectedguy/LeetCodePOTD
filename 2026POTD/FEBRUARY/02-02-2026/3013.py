class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        ans = float("inf")
        n = len(nums)
        i = 2
        j = 2 + dist
        total = 0
        minHeap = []
        maxHeap = []
        s = set()
        for p in range(i, j):
            heapq.heappush(minHeap, (nums[p], p))
        for _ in range(k - 2):
            val, idx = heapq.heappop(minHeap)
            total += val
            s.add(idx)
            heapq.heappush(maxHeap, (-val, idx))
        while n - i > k - 2:
            ans = min(ans, total + nums[0] + nums[i - 1])
            while minHeap and minHeap[0][1] <= i:
                heapq.heappop(minHeap)
            while maxHeap and maxHeap[0][1] <= i:
                heapq.heappop(maxHeap)
            if j < n:
                if maxHeap and nums[j] < -maxHeap[0][0]:
                    val, idx = heapq.heappop(maxHeap)
                    val = -val
                    heapq.heappush(minHeap, (val, idx))
                    s.remove(idx)
                    total -= val
                    total += nums[j]
                    heapq.heappush(maxHeap, (-nums[j], j))
                    s.add(j)
                else:
                    heapq.heappush(minHeap, (nums[j], j))
                j += 1
            if i in s:
                s.remove(i)
                total -= nums[i]
                val, idx = heapq.heappop(minHeap)
                total += val
                s.add(idx)
                heapq.heappush(maxHeap, (-val, idx))
            i += 1
        ans = min(ans, total + nums[0] + nums[i - 1])
        return ans