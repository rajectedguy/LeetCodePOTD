class Solution {
public:
    int minOperations(string s) {
        int cnt = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] != (i % 2 ? '1' : '0'))
                cnt++;
        }
        return min(cnt, (int)s.size() - cnt);
    }
};