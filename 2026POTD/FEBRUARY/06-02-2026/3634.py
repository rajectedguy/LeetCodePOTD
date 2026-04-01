class Solution:
    def minRemoval(self, n: List[int], k: int) -> int:
        n.sort()
        o=l=0
        for r,v in enumerate(n):
            while k*n[l]<v:l+=1
            o=max(o,r-l)
        return len(n)-o-1      