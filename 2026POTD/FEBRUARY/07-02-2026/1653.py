class Solution:
    def minimumDeletions(self, s: str) -> int:
        res=0
        count_b=0
        for char in s:
            if char=="b":
                count_b+=1
            else:
                res=min(res+1,count_b)
        return res
        