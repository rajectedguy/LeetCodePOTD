class Solution {

    /**
     * @param Integer[][] $bottomLeft
     * @param Integer[][] $topRight
     * @return Integer
     */
    function largestSquareArea($bottomLeft, $topRight) {
        $n = count($bottomLeft);
        $ans = 0;
        for ($i = 0; $i < $n; $i++) {
            for ($j = $i + 1; $j < $n; $j++) {
                $x1 = max($bottomLeft[$i][0], $bottomLeft[$j][0]);
                $y1 = max($bottomLeft[$i][1], $bottomLeft[$j][1]);
                $x2 = min($topRight[$i][0], $topRight[$j][0]);
                $y2 = min($topRight[$i][1], $topRight[$j][1]);
                if ($x2 > $x1 && $y2 > $y1) {
                    $side = min($x2 - $x1, $y2 - $y1);
                    $ans = max($ans, $side * $side);
                }
            }
        }
        return $ans;
    }
}