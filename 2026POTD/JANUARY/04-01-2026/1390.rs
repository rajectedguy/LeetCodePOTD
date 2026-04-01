impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        let mut ans = 0;

        for x in nums {
            let mut n = x;
            let mut p = 0;
            let mut q = 0;
            let mut cnt = 0;

            let mut i = 2;
            while i * i <= n && cnt <= 2 {
                if n % i == 0 {
                    cnt += 1;
                    if cnt == 1 { p = i; } else { q = i; }
                    while n % i == 0 {
                        n /= i;
                    }
                }
                i += 1;
            }

            if n > 1 {
                cnt += 1;
                if cnt == 1 { p = n; } else { q = n; }
            }

            if cnt == 2 && p * q == x {
                ans += 1 + p + q + x;
            } else if cnt == 1 && p * p * p == x {
                ans += 1 + p + p * p + x;
            }
        }

        ans
    }
}