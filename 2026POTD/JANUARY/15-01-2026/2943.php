class Solution {

    function maximizeSquareHoleArea($n, $m, $hBars, $vBars) {
        $longest = function(&$a) {
            sort($a);
            $best = 1;
            $cur = 1;
            for ($i = 1; $i < count($a); $i++) {
                if ($a[$i] == $a[$i - 1] + 1) {
                    $cur++;
                } else {
                    $cur = 1;
                }
                if ($cur > $best) {
                    $best = $cur;
                }
            }
            return $best + 1;
        };

        $side = min($longest($hBars), $longest($vBars));
        return $side * $side;
    }
}