class Solution:
    def longestBalanced(self, s: str) -> int:
        res = 0
        if len(s) == 1:res = 1
        def singlechar(s):
            currCount = 1
            maxLength = 0
            for i in range(len(s)-1):
                if s[i] == s[i+1]:
                    currCount +=1
                else:
                    currCount = 1
                maxLength = max(maxLength, currCount)
            return maxLength
        res = max(res, singlechar(s))
        #print(res)
        def twochar(char1, char2, wrong, s):
            prefixMap = {0:-1}
            currCount = 0
            maxLength = 0
            for  i in range(len(s)):
                if s[i] == wrong:
                    currCount = 0
                    prefixMap = {0:i}
                else:
                    if s[i] == char1:
                        currCount += 1
                    elif s[i] == char2:
                        currCount -=1
                    
                    if currCount in prefixMap:
                        maxLength = max(maxLength, i - prefixMap[currCount])
                    else:
                        prefixMap[currCount] = i
            return maxLength

        res = max(res,twochar("a", "b", "c", s))
        #print("two", res)
        res = max(res,twochar("b", "c", "a", s))
        res = max(res,twochar("a", "c", "b", s))
        def threechar():
            prefixMap = {(0,0):-1}
            char_a = char_b = char_c = 0
            currCount = 0
            maxLength = 0

            for i in range(len(s)):
                if s[i] == "a":
                    char_a+=1
                elif s[i] == "b":
                    char_b+=1
                elif s[i] == "c":
                    char_c +=1
                
                key = (char_a - char_b, char_b - char_c)

                if key in prefixMap:
                    maxLength = max(maxLength, i - prefixMap[key])
                else:
                    prefixMap[key] = i
            return maxLength
        res  = max(res, threechar())
        return res