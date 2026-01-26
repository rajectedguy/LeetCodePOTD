class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++)
            mn = Math.min(mn, arr[i] - arr[i - 1]);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++)
            if (arr[i] - arr[i - 1] == mn)
                res.add(Arrays.asList(arr[i - 1], arr[i]));
        return res;
    }
}