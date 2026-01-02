class Solution {
    function repeatedNTimes($nums) {
        $set = [];
        foreach ($nums as $x) {
            if (isset($set[$x])) return $x;
            $set[$x] = true;
        }
        return -1;
    }
}