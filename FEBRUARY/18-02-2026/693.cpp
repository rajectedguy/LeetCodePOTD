class Solution {
public:
    bool hasAlternatingBits(int n) {
      unsigned int r = (n ^ (n>>1));
       return !(r & (r+1) );
    }
};