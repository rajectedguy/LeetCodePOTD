func numOfWays(n int) int {
    const MOD int64 = 1000000007
    var aba int64 = 6
    var abc int64 = 6
    for i := 2; i <= n; i++ {
        newAba := (aba*3 + abc*2) % MOD
        newAbc := (aba*2 + abc*2) % MOD
        aba = newAba
        abc = newAbc
    }
    return int((aba + abc) % MOD)
}