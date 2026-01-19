class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function largestMagicSquare($grid) {
        $m = count($grid);
        $n = count($grid[0]);

        $rowSum = array_fill(0, $m, array_fill(0, $n + 1, 0));
        $colSum = array_fill(0, $m + 1, array_fill(0, $n, 0));
        $diag1 = array_fill(0, $m + 1, array_fill(0, $n + 1, 0)); 
        $diag2 = array_fill(0, $m + 1, array_fill(0, $n + 1, 0)); 


        for ($i = 0; $i < $m; $i++) {
            for ($j = 0; $j < $n; $j++) {
                $rowSum[$i][$j+1] = $rowSum[$i][$j] + $grid[$i][$j];
                $colSum[$i+1][$j] = $colSum[$i][$j] + $grid[$i][$j];
                $diag1[$i+1][$j+1] = $diag1[$i][$j] + $grid[$i][$j];
                $diag2[$i+1][$j] = $diag2[$i][$j+1] + $grid[$i][$j];
            }
        }

        $maxK = min($m, $n);
        for ($k = $maxK; $k >= 1; $k--) {
            for ($i = 0; $i <= $m - $k; $i++) {
                for ($j = 0; $j <= $n - $k; $j++) {
                    $d1 = $diag1[$i+$k][$j+$k] - $diag1[$i][$j];
                    $d2 = $diag2[$i+$k][$j] - $diag2[$i][$j+$k];
                    if ($d1 != $d2) continue;

                    $ok = true;
                    for ($x = 0; $x < $k; $x++) {
                        $rsum = $rowSum[$i+$x][$j+$k] - $rowSum[$i+$x][$j];
                        $csum = $colSum[$i+$k][$j+$x] - $colSum[$i][$j+$x];
                        if ($rsum != $d1 || $csum != $d1) {
                            $ok = false;
                            break;
                        }
                    }
                    if ($ok) return $k;
                }
            }
        }

        return 1;
    }
}