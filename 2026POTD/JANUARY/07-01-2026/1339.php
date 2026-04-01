class Solution {
    private $total = 0;
    private $best = 0;
    private $MOD = 1000000007;

    private function sum($node) {
        if ($node === null) return 0;
        return $node->val + $this->sum($node->left) + $this->sum($node->right);
    }

    private function dfs($node) {
        if ($node === null) return 0;
        $s = $node->val + $this->dfs($node->left) + $this->dfs($node->right);
        $prod = $s * ($this->total - $s);
        if ($prod > $this->best) $this->best = $prod;
        return $s;
    }

    function maxProduct($root) {
        $this->total = $this->sum($root);
        $this->best = 0;
        $this->dfs($root);
        return $this->best % $this->MOD;
    }
}