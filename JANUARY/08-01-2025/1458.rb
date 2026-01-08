# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Integer}
def max_dot_product(nums1, nums2)
  n, m = nums1.length, nums2.length
  neg = -1_000_000_000
  dp = Array.new(n + 1) { Array.new(m + 1, neg) }

  (1..n).each do |i|
    (1..m).each do |j|
      prod = nums1[i - 1] * nums2[j - 1]
      dp[i][j] = [
        prod,
        dp[i - 1][j],
        dp[i][j - 1],
        dp[i - 1][j - 1] + prod
      ].max
    end
  end

  dp[n][m]
end