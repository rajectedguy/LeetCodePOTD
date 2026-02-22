class Solution {
private:
    string toBinary(int n ){
        string ans = "";
        while(n > 0){
            if(n % 2 == 1){
                ans.push_back('1');
            } else {
                ans.push_back('0');
            }
            n /= 2;
        }
        return ans; 
    }
public:
    int binaryGap(int n) {
        string s = toBinary(n);
        int last = -1;  
        int maxGap = 0;

        for (int i = 0; i < (int)s.size(); i++) {
            if (s[i] == '1') {
                if (last != -1) {
                    maxGap = max(maxGap, i - last);
                }
                last = i;
            }
        }
        return maxGap;
    }
};