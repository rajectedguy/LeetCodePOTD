object Solution {
    def numOfWays(n: Int): Int = {
        val MOD = 1000000007L
        var aba = 6L
        var abc = 6L
        for (_ <- 2 to n) {
            val newAba = (aba * 3 + abc * 2) % MOD
            val newAbc = (aba * 2 + abc * 2) % MOD
            aba = newAba
            abc = newAbc
        }
        ((aba + abc) % MOD).toInt
    }
}