class Solution {
  int maximizeSquareArea(int m, int n, List<int> hFences, List<int> vFences) {
    const int MOD = 1000000007;

    List<int> h = [...hFences, 1, m];
    List<int> v = [...vFences, 1, n];

    h.sort();
    v.sort();

    Set<int> hs = {};
    for (int i = 0; i < h.length; i++) {
      for (int j = i + 1; j < h.length; j++) {
        hs.add(h[j] - h[i]);
      }
    }

    int best = -1;
    for (int i = 0; i < v.length; i++) {
      for (int j = i + 1; j < v.length; j++) {
        int d = v[j] - v[i];
        if (hs.contains(d) && d > best) {
          best = d;
        }
      }
    }

    if (best == -1) return -1;
    return ((best.toInt() * best.toInt()) % MOD);
  }
}