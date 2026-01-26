class Solution {
  List<List<int>> minimumAbsDifference(List<int> arr) {
    arr.sort();
    int mn = 1 << 30;
    for (int i = 1; i < arr.length; i++)
      mn = mn < arr[i] - arr[i - 1] ? mn : arr[i] - arr[i - 1];

    List<List<int>> res = [];
    for (int i = 1; i < arr.length; i++)
      if (arr[i] - arr[i - 1] == mn)
        res.add([arr[i - 1], arr[i]]);
    return res;
  }
}