class Solution {

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalRectangle($matrix) {
        if (empty($matrix)) return 0;

        $cols = count($matrix[0]);
        $heights = array_fill(0, $cols, 0);
        $ans = 0;

        foreach ($matrix as $row) {
            for ($j = 0; $j < $cols; $j++) {
                $heights[$j] = ($row[$j] === '1') ? $heights[$j] + 1 : 0;
            }

            $stack = [];
            for ($i = 0; $i <= $cols; $i++) {
                $h = ($i == $cols) ? 0 : $heights[$i];
                while (!empty($stack) && $h < $heights[end($stack)]) {
                    $height = $heights[array_pop($stack)];
                    $width = empty($stack) ? $i : $i - end($stack) - 1;
                    $ans = max($ans, $height * $width);
                }
                $stack[] = $i;
            }
        }

        return $ans;
    }
}