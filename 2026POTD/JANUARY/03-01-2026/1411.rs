impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        const MOD: i64 = 1_000_000_007;
        let mut aba: i64 = 6;
        let mut abc: i64 = 6;
        for _ in 2..=n {
            let new_aba = (aba * 3 + abc * 2) % MOD;
            let new_abc = (aba * 2 + abc * 2) % MOD;
            aba = new_aba;
            abc = new_abc;
        }
        ((aba + abc) % MOD) as i32
    }
}