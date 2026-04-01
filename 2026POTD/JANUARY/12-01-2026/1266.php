class Solution {

    /**
     * @param Integer[][] $points
     * @return Integer
     */
    function minTimeToVisitAllPoints($points) {
        $ans = 0;
        for ($i = 1; $i < count($points); $i++) {
            $dx = abs($points[$i][0] - $points[$i - 1][0]);
            $dy = abs($points[$i][1] - $points[$i - 1][1]);
            $ans += max($dx, $dy);
        }
        return $ans;
    }
}