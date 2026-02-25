class Solution {
public:
    static bool comp(int a , int b){
        if(__builtin_popcount(a) == __builtin_popcount(b)){
            return a<b;
        }
        else{
            int x=__builtin_popcount(a);
            int y=__builtin_popcount(b);
            return x<y;
        }
        return true;
    }
    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(),arr.end(),comp);
        return arr;
    }
};