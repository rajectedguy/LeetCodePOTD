impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        use std::collections::HashSet;
        let mut set = HashSet::new();
        for x in nums {
            if !set.insert(x) {
                return x;
            }
        }
        -1
    }
}