class Solution {

    function maxDotProduct($nums1, $nums2) {
        $n = count($nums1);
        $m = count($nums2);
        $neg = -1000000000;
        $dp = array_fill(0, $n + 1, array_fill(0, $m + 1, $neg));

        for ($i = 1; $i <= $n; $i++) {
            for ($j = 1; $j <= $m; $j++) {
                $prod = $nums1[$i - 1] * $nums2[$j - 1];
                $dp[$i][$j] = max(
                    $prod,
                    $dp[$i - 1][$j],
                    $dp[$i][$j - 1],
                    $dp[$i - 1][$j - 1] + $prod
                );
            }
        }
        return $dp[$n][$m];
    }
}