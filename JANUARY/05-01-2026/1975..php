class Solution {
    function maxMatrixSum($matrix) {
        $sum = 0;
        $neg = 0;
        $mn = PHP_INT_MAX;
        foreach ($matrix as $row) {
            foreach ($row as $x) {
                if ($x < 0) $neg++;
                $ax = abs($x);
                $sum += $ax;
                if ($ax < $mn) $mn = $ax;
            }
        }
        if ($neg % 2 == 1) $sum -= 2 * $mn;
        return $sum;
    }
}