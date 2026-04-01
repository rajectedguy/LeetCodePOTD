class Solution {
public:
    char findKthBit(int n, int k) {
        string temp="0";
        for(int i=1;i<n;i++){
            int m=temp.size();
            temp.push_back('1');
            for(int j=m-1;j>=0;j--){
                if(temp[j]=='1'){
                    temp.push_back('0');
                }
                else{
                    temp.push_back('1');
                }
            }
        }
        return temp[k-1];
    }
};