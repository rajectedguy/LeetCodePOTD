class Solution {
    function minimumDifference($nums, $k) {
        if ($k <= 1) return 0;
        sort($nums);
        $ans = PHP_INT_MAX;
        $n = count($nums);
        for ($i = 0; $i + $k - 1 < $n; $i++) {
            $ans = min($ans, $nums[$i + $k - 1] - $nums[$i]);
        }
        return $ans;
    }
}