class Solution {

    /**
     * @param Integer[][] $squares
     * @return Float
     */
    function separateSquares($squares) {
        $xs = [];
        $events = [];

        foreach ($squares as $s) {
            list($x, $y, $l) = $s;
            $xs[] = $x;
            $xs[] = $x + $l;
            $events[] = [$y, $x, $x + $l, 1];
            $events[] = [$y + $l, $x, $x + $l, -1];
        }

        sort($xs);
        $xs = array_values(array_unique($xs));
        $m = count($xs);
        $idx = array_flip($xs);

        $cnt = array_fill(0, 4 * $m, 0);
        $seglen = array_fill(0, 4 * $m, 0);

        $update = function($i, $l, $r, $ql, $qr, $v) use (&$cnt, &$seglen, $xs, &$update) {
            if ($qr <= $l || $r <= $ql) return;
            if ($ql <= $l && $r <= $qr) {
                $cnt[$i] += $v;
            } else {
                $mid = ($l + $r) >> 1;
                $update($i << 1, $l, $mid, $ql, $qr, $v);
                $update($i << 1 | 1, $mid, $r, $ql, $qr, $v);
            }
            if ($cnt[$i] > 0) {
                $seglen[$i] = $xs[$r] - $xs[$l];
            } else if ($l + 1 == $r) {
                $seglen[$i] = 0;
            } else {
                $seglen[$i] = $seglen[$i << 1] + $seglen[$i << 1 | 1];
            }
        };

        usort($events, function($a, $b) { return $a[0] <=> $b[0]; });

        $prev = $events[0][0];
        $total = 0.0;
        $i = 0;
        $n = count($events);

        while ($i < $n) {
            $y = $events[$i][0];
            $dy = $y - $prev;
            if ($dy > 0 && $seglen[1] > 0) $total += $seglen[1] * $dy;

            while ($i < $n && $events[$i][0] == $y) {
                list(, $x1, $x2, $t) = $events[$i];
                $update(1, 0, $m, $idx[$x1], $idx[$x2], $t);
                $i++;
            }
            $prev = $y;
        }

        $half = $total / 2.0;
        $cnt = array_fill(0, 4 * $m, 0);
        $seglen = array_fill(0, 4 * $m, 0);

        $prev = $events[0][0];
        $cur = 0.0;
        $i = 0;

        while ($i < $n) {
            $y = $events[$i][0];
            $dy = $y - $prev;
            if ($dy > 0 && $seglen[1] > 0) {
                $area = $seglen[1] * $dy;
                if ($cur + $area >= $half) return $prev + ($half - $cur) / $seglen[1];
                $cur += $area;
            }
            while ($i < $n && $events[$i][0] == $y) {
                list(, $x1, $x2, $t) = $events[$i];
                $update(1, 0, $m, $idx[$x1], $idx[$x2], $t);
                $i++;
            }
            $prev = $y;
        }

        return $prev;
    }
}