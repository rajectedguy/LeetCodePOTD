class Solution {
  int maxMatrixSum(List<List<int>> matrix) {
    int neg = 0;
    int mn = 1 << 62;
    int sum = 0;
    for (var row in matrix) {
      for (var x in row) {
        if (x < 0) neg++;
        int ax = x.abs();
        sum += ax;
        if (ax < mn) mn = ax;
      }
    }
    if (neg.isOdd) sum -= 2 * mn;
    return sum;
  }
}