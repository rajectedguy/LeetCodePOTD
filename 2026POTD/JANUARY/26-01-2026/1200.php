class Solution {
    function minimumAbsDifference($arr) {
        sort($arr);
        $mn = PHP_INT_MAX;
        for ($i = 1; $i < count($arr); $i++)
            $mn = min($mn, $arr[$i] - $arr[$i - 1]);

        $res = [];
        for ($i = 1; $i < count($arr); $i++)
            if ($arr[$i] - $arr[$i - 1] == $mn)
                $res[] = [$arr[$i - 1], $arr[$i]];
        return $res;
    }
}