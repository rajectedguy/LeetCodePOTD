use std::collections::HashSet;

impl Solution {
    pub fn maximize_square_area(m: i32, n: i32, h_fences: Vec<i32>, v_fences: Vec<i32>) -> i32 {
        const MOD: i64 = 1_000_000_007;

        let mut h = h_fences;
        let mut v = v_fences;

        h.push(1);
        h.push(m);
        v.push(1);
        v.push(n);

        h.sort();
        v.sort();

        let mut hs: HashSet<i32> = HashSet::new();
        for i in 0..h.len() {
            for j in (i + 1)..h.len() {
                hs.insert(h[j] - h[i]);
            }
        }

        let mut best: i32 = -1;
        for i in 0..v.len() {
            for j in (i + 1)..v.len() {
                let d = v[j] - v[i];
                if hs.contains(&d) {
                    best = best.max(d);
                }
            }
        }

        if best == -1 {
            -1
        } else {
            ((best as i64 * best as i64) % MOD) as i32
        }
    }
}