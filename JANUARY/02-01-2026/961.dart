class Solution {
  int repeatedNTimes(List<int> nums) {
    final set = <int>{};
    for (final x in nums) {
      if (!set.add(x)) return x;
    }
    return -1;
  }
}