function maxDotProduct(nums1: number[], nums2: number[]): number {
    const n = nums1.length, m = nums2.length;
    const NEG = -1e9;
    const dp: number[][] = Array.from({ length: n + 1 }, () => Array(m + 1).fill(NEG));

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            const prod = nums1[i - 1] * nums2[j - 1];
            dp[i][j] = Math.max(
                prod,
                dp[i - 1][j],
                dp[i][j - 1],
                dp[i - 1][j - 1] + prod
            );
        }
    }
    return dp[n][m];
}