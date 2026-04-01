def minimum_delete_sum(s1, s2)
    n, m = s1.length, s2.length
    dp = Array.new(n + 1) { Array.new(m + 1, 0) }

    (n - 1).downto(0) do |i|
        dp[i][m] = dp[i + 1][m] + s1[i].ord
    end

    (m - 1).downto(0) do |j|
        dp[n][j] = dp[n][j + 1] + s2[j].ord
    end

    (n - 1).downto(0) do |i|
        (m - 1).downto(0) do |j|
            if s1[i] == s2[j]
                dp[i][j] = dp[i + 1][j + 1]
            else
                dp[i][j] = [
                    s1[i].ord + dp[i + 1][j],
                    s2[j].ord + dp[i][j + 1]
                ].min
            end
        end
    end

    dp[0][0]
end