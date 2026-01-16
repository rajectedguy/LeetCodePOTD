class Solution {

    /**
     * @param Integer $m
     * @param Integer $n
     * @param Integer[] $hFences
     * @param Integer[] $vFences
     * @return Integer
     */
    function maximizeSquareArea($m, $n, $hFences, $vFences) {
        $MOD = 1000000007;

        $h = $hFences;
        $v = $vFences;

        $h[] = 1; $h[] = $m;
        $v[] = 1; $v[] = $n;

        sort($h);
        sort($v);

        $hs = [];
        $hlen = count($h);
        for ($i = 0; $i < $hlen; $i++) {
            for ($j = $i + 1; $j < $hlen; $j++) {
                $hs[$h[$j] - $h[$i]] = true;
            }
        }

        $best = -1;
        $vlen = count($v);
        for ($i = 0; $i < $vlen; $i++) {
            for ($j = $i + 1; $j < $vlen; $j++) {
                $d = $v[$j] - $v[$i];
                if (isset($hs[$d])) {
                    if ($d > $best) $best = $d;
                }
            }
        }

        if ($best === -1) return -1;
        return (int)(($best * $best) % $MOD);
    }
}