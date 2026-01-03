# @param {Integer} n
# @return {Integer}
def num_of_ways(n)
    mod = 1_000_000_007
    aba = 6
    abc = 6
    (2..n).each do
        new_aba = (aba * 3 + abc * 2) % mod
        new_abc = (aba * 2 + abc * 2) % mod
        aba = new_aba
        abc = new_abc
    end
    (aba + abc) % mod
end