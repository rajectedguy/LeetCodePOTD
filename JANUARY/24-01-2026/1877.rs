impl Solution {
    pub fn min_pair_sum(mut nums: Vec<i32>) -> i32 {
        nums.sort();
        let mut i = 0usize;
        let mut j = nums.len() - 1;
        let mut ans = 0;
        while i < j {
            ans = ans.max(nums[i] + nums[j]);
            i += 1;
            j -= 1;
        }
        ans
    }
}