class Solution {
public:
    int bitwiseComplement(int n) {
        if(n==0)return 1;
        int digits = floor(log2(n)) + 1;
        int number= pow(2,digits)-1;
        int ans= n ^ number;
        return ans;
    }
};