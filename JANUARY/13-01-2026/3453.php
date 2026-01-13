class Solution {

    /**
     * @param Integer[][] $squares
     * @return Float
     */
    function separateSquares($squares) {
        $events = [];

        foreach ($squares as $s) {
            $y = (float)$s[1];
            $l = (float)$s[2];
            $events[] = [$y, $l];
            $events[] = [$y + $l, -$l];
        }

        usort($events, function($a, $b) {
            return $a[0] <=> $b[0];
        });

        $segments = [];
        $curWidth = 0.0;
        $prevY = $events[0][0];
        $totalArea = 0.0;

        foreach ($events as [$y, $delta]) {
            if ($y > $prevY && $curWidth > 0) {
                $area = ($y - $prevY) * $curWidth;
                $segments[] = [$prevY, $y, $curWidth, $area];
                $totalArea += $area;
            }
            $curWidth += $delta;
            $prevY = $y;
        }

        $target = $totalArea / 2.0;
        $acc = 0.0;

        foreach ($segments as [$y1, $y2, $w, $area]) {
            if ($acc + $area >= $target) {
                return $y1 + ($target - $acc) / $w;
            }
            $acc += $area;
        }

        return 0.0;
    }
}