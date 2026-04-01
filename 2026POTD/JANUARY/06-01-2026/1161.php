class Solution {

    function maxLevelSum($root) {
        $q = [$root];
        $level = 1;
        $ans = 1;
        $maxSum = PHP_INT_MIN;

        while (!empty($q)) {
            $size = count($q);
            $sum = 0;

            for ($i = 0; $i < $size; $i++) {
                $node = array_shift($q);
                $sum += $node->val;
                if ($node->left !== null) $q[] = $node->left;
                if ($node->right !== null) $q[] = $node->right;
            }

            if ($sum > $maxSum) {
                $maxSum = $sum;
                $ans = $level;
            }
            $level++;
        }
        return $ans;
    }
}