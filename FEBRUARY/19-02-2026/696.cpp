class Solution {
public:
    int countBinarySubstrings(string s) {
        int currCnt = 1,prevCnt = 0,ans = 0;
        for(int i = 1;i < s.size();i++){
            if(s[i] == s[i-1]){
                currCnt++;
            }else{
                ans += min(currCnt,prevCnt);
                prevCnt = currCnt;
                currCnt = 1;
            }
        }
        ans += min(prevCnt,currCnt);
        return ans;
    }
};