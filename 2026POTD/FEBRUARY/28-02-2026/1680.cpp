class Solution {
public:
    int concatenatedBinary(int n) {
        int bits = 0;
        long long ans = 0;
        int mod = 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bits++;
            }
            ans = ((ans << bits) % (mod) + i) % (mod);
        }

        return (int)ans;
    }
};