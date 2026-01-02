public class Solution {
    public int RepeatedNTimes(int[] nums) {
        var set = new HashSet<int>();
        foreach (var x in nums) {
            if (!set.Add(x)) return x;
        }
        return -1;
    }
}