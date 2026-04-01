class Solution {

    /**
     * @param Integer[][] $mat
     * @param Integer $threshold
     * @return Integer
     */
    function maxSideLength($mat, $threshold) {
        $m = count($mat);
        $n = count($mat[0]);
        

        $prefix = array_fill(0, $m + 1, array_fill(0, $n + 1, 0));
        for ($i = 0; $i < $m; $i++) {
            for ($j = 0; $j < $n; $j++) {
                $prefix[$i + 1][$j + 1] = $mat[$i][$j] + $prefix[$i][$j + 1] + $prefix[$i + 1][$j] - $prefix[$i][$j];
            }
        }
        
        $left = 0;
        $right = min($m, $n);
        $ans = 0;
        
        while ($left <= $right) {
            $mid = intdiv($left + $right, 2);
            $found = false;
            
            for ($i = $mid; $i <= $m && !$found; $i++) {
                for ($j = $mid; $j <= $n && !$found; $j++) {
                    $total = $prefix[$i][$j] - $prefix[$i - $mid][$j] - $prefix[$i][$j - $mid] + $prefix[$i - $mid][$j - $mid];
                    if ($total <= $threshold) $found = true;
                }
            }
            
            if ($found) {
                $ans = $mid;
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
        
        return $ans;
    }
}