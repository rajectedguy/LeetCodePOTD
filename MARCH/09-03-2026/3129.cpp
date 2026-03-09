class Solution {
public:
    int numberOfStableArrays(int zero, int one, int limit) {
        const int MOD = 1e9 + 7;

        vector<vector<long long>> dp0(zero + 1, vector<long long>(one + 1, 0));
        vector<vector<long long>> dp1(zero + 1, vector<long long>(one + 1, 0));

        for (int i = 1; i <= min(zero, limit); i++)
            dp0[i][0] = 1;

        for (int j = 1; j <= min(one, limit); j++)
            dp1[0][j] = 1;

        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {

                for (int k = 1; k <= limit && z - k >= 0; k++)
                    dp0[z][o] = (dp0[z][o] + dp1[z-k][o]) % MOD;

                for (int k = 1; k <= limit && o - k >= 0; k++)
                    dp1[z][o] = (dp1[z][o] + dp0[z][o-k]) % MOD;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % MOD;
    }
};