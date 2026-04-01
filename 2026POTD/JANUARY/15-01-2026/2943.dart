class Solution {
  int maximizeSquareHoleArea(int n, int m, List<int> hBars, List<int> vBars) {
    int longest(List<int> a) {
      a.sort();
      int best = 1, cur = 1;
      for (int i = 1; i < a.length; i++) {
        if (a[i] == a[i - 1] + 1) {
          cur++;
        } else {
          cur = 1;
        }
        if (cur > best) best = cur;
      }
      return best + 1;
    }

    int side = longest(hBars);
    int vSide = longest(vBars);
    int minSide = side < vSide ? side : vSide;
    return minSide * minSide;
  }
}