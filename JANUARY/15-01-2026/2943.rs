impl Solution {
    pub fn maximize_square_hole_area(n: i32, m: i32, mut h_bars: Vec<i32>, mut v_bars: Vec<i32>) -> i32 {
        fn longest(mut a: Vec<i32>) -> i32 {
            a.sort();
            let mut best = 1;
            let mut cur = 1;
            for i in 1..a.len() {
                if a[i] == a[i - 1] + 1 {
                    cur += 1;
                } else {
                    cur = 1;
                }
                if cur > best {
                    best = cur;
                }
            }
            best + 1
        }

        let side = std::cmp::min(longest(h_bars), longest(v_bars));
        side * side
    }
}