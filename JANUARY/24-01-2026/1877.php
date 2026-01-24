class Solution {
    function minPairSum($nums) {
        sort($nums);
        $i = 0;
        $j = count($nums) - 1;
        $ans = 0;
        while ($i < $j) {
            $ans = max($ans, $nums[$i] + $nums[$j]);
            $i++;
            $j--;
        }
        return $ans;
    }
}