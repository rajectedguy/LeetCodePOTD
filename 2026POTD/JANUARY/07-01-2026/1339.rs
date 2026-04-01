use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn max_product(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        const MOD: i64 = 1_000_000_007;
        let mut total: i64 = 0;
        let mut best: i64 = 0;

        fn sum(node: &Option<Rc<RefCell<TreeNode>>>) -> i64 {
            if let Some(n) = node {
                let n = n.borrow();
                n.val as i64 + sum(&n.left) + sum(&n.right)
            } else {
                0
            }
        }

        fn dfs(node: &Option<Rc<RefCell<TreeNode>>>, total: i64, best: &mut i64) -> i64 {
            if let Some(n) = node {
                let n = n.borrow();
                let s = n.val as i64 + dfs(&n.left, total, best) + dfs(&n.right, total, best);
                let prod = s * (total - s);
                if prod > *best {
                    *best = prod;
                }
                s
            } else {
                0
            }
        }

        total = sum(&root);
        dfs(&root, total, &mut best);
        (best % MOD) as i32
    }
}