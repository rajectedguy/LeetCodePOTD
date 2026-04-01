public class Solution {
    public IList<IList<int>> MinimumAbsDifference(int[] arr) {
        Array.Sort(arr);
        int mn = int.MaxValue;
        for (int i = 1; i < arr.Length; i++)
            mn = Math.Min(mn, arr[i] - arr[i - 1]);

        IList<IList<int>> res = new List<IList<int>>();
        for (int i = 1; i < arr.Length; i++)
            if (arr[i] - arr[i - 1] == mn)
                res.Add(new List<int> { arr[i - 1], arr[i] });
        return res;
    }
}