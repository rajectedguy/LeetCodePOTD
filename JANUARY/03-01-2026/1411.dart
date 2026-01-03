class Solution {
  int numOfWays(int n) {
    const int MOD = 1000000007;
    int aba = 6, abc = 6;
    for (int i = 2; i <= n; i++) {
      int newAba = (aba * 3 + abc * 2) % MOD;
      int newAbc = (aba * 2 + abc * 2) % MOD;
      aba = newAba;
      abc = newAbc;
    }
    return (aba + abc) % MOD;
  }
}