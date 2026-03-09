MOD = 1_000_000_007

MAXN = 400
fact = [1] * (MAXN + 1)
invf = [1] * (MAXN + 1)

for i in range(2, MAXN + 1):
    fact[i] = (fact[i - 1] * i) % MOD

invf[MAXN] = pow(fact[MAXN], MOD - 2, MOD)
for i in range(MAXN, 0, -1):
    invf[i - 1] = (invf[i] * i) % MOD

def comb(n, r):
    if r < 0 or r > n: return 0
    return fact[n] * invf[r] % MOD * invf[n - r] % MOD

class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        def W(n, g, limit):
            if n < g:
                return 0
            res = 0

            for i in range(g + 1):
                rem = n - 1 - i * limit
                if rem < g - 1:
                    break

                ways = comb(g, i) * comb(rem, g - 1) % MOD
                if i % 2 == 1:
                    res = (res - ways + MOD) % MOD
                else:
                    res = (res + ways) % MOD
            return res

        ans = 0
        for c0 in range(1, zero + 1):
            for c1 in (c0 - 1, c0, c0 + 1):
                if c1 < 1 or c1 > one:
                    continue

                ways0 = W(zero, c0, limit)
                if ways0 == 0: continue

                ways1 = W(one, c1, limit)
                if ways1 == 0: continue

                ways = (ways0 * ways1) % MOD

                if c0 == c1:
                    ans = (ans + ways * 2) % MOD
                else:
                    ans = (ans + ways) % MOD

        return ans