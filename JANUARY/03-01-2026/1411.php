class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function numOfWays($n) {
        $MOD = 1000000007;
        $aba = 6;
        $abc = 6;
        for ($i = 2; $i <= $n; $i++) {
            $newAba = ($aba * 3 + $abc * 2) % $MOD;
            $newAbc = ($aba * 2 + $abc * 2) % $MOD;
            $aba = $newAba;
            $abc = $newAbc;
        }
        return ($aba + $abc) % $MOD;
    }
}