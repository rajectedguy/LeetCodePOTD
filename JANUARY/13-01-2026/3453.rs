impl Solution {
    pub fn separate_squares(squares: Vec<Vec<i32>>) -> f64 {
        let mut lo = 1e18f64;
        let mut hi = -1e18f64;
        let mut total = 0.0f64;

        for s in &squares {
            let y = s[1] as f64;
            let l = s[2] as f64;
            if y < lo {
                lo = y;
            }
            if y + l > hi {
                hi = y + l;
            }
            total += l * l;
        }

        let target = total / 2.0;

        for _ in 0..80 {
            let mid = (lo + hi) * 0.5;
            let mut below = 0.0f64;
            for s in &squares {
                let y = s[1] as f64;
                let l = s[2] as f64;
                if mid > y {
                    let h = (mid - y).min(l);
                    below += h * l;
                }
            }
            if below < target {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        lo
    }
}