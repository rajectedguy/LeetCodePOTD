class Solution {
    func numOfWays(_ n: Int) -> Int {
        let MOD = 1_000_000_007
        var aba = 6
        var abc = 6
        if n == 1 {
            return (aba + abc) % MOD
        }
        for _ in 2...n {
            let newAba = (aba * 3 + abc * 2) % MOD
            let newAbc = (aba * 2 + abc * 2) % MOD
            aba = newAba
            abc = newAbc
        }
        return (aba + abc) % MOD
    }
}