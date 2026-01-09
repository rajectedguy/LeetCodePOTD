class Solution {
    function subtreeWithAllDeepest($root) {
        $dfs = function($node) use (&$dfs) {
            if ($node === null) return [0, null];
            [$ld, $ln] = $dfs($node->left);
            [$rd, $rn] = $dfs($node->right);
            if ($ld > $rd) return [$ld + 1, $ln];
            if ($rd > $ld) return [$rd + 1, $rn];
            return [$ld + 1, $node];
        };
        return $dfs($root)[1];
    }
}