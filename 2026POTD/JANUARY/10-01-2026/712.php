class Solution {

    /**
     * @param String $s1
     * @param String $s2
     * @return Integer
     */
    function minimumDeleteSum($s1, $s2) {
        $n = strlen($s1);
        $m = strlen($s2);
        $dp = array_fill(0, $n + 1, array_fill(0, $m + 1, 0));

        for ($i = $n - 1; $i >= 0; $i--) {
            $dp[$i][$m] = $dp[$i + 1][$m] + ord($s1[$i]);
        }

        for ($j = $m - 1; $j >= 0; $j--) {
            $dp[$n][$j] = $dp[$n][$j + 1] + ord($s2[$j]);
        }

        for ($i = $n - 1; $i >= 0; $i--) {
            for ($j = $m - 1; $j >= 0; $j--) {
                if ($s1[$i] === $s2[$j]) {
                    $dp[$i][$j] = $dp[$i + 1][$j + 1];
                } else {
                    $dp[$i][$j] = min(
                        ord($s1[$i]) + $dp[$i + 1][$j],
                        ord($s2[$j]) + $dp[$i][$j + 1]
                    );
                }
            }
        }

        return $dp[0][0];
    }
}