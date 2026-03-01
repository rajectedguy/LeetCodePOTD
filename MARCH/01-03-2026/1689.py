class Solution:
    def minPartitions(self, n: str) -> int:
        maxi = 0
        for i in n:
            maxi = max(maxi,int(i))
        return maxi