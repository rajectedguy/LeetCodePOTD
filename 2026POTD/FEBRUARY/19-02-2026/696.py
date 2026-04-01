class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        result = prev = 0
        curr = 1
        for i in range(1,len(s)):
            if s[i-1] == s[i]:
                curr+=1
            else:
                result+=min(curr,prev)
                prev,curr = curr,1
        result += min(curr,prev)
        return result