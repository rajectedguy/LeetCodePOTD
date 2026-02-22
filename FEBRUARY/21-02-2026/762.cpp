class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        int count = 0;

        int isPrime[33] = {
            0, 0, 2, 3, 0, 5, 0, 7, 0, 0, 0, 11, 0,
            13, 0, 0, 0, 17, 0, 19, 0, 0, 0, 23,
            0, 0, 0, 0, 0, 29, 0, 31, 0
        };

        while(left <= right) {
            if(isPrime[__builtin_popcount(left)]) {
                count++;
            }
            left++;
        }

        return count;
    }
};