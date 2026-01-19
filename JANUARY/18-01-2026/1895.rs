impl Solution {
    pub fn largest_magic_square(grid: Vec<Vec<i32>>) -> i32 {
        let m = grid.len();
        let n = grid[0].len();

        // Prefix sums
        let mut row_sum = vec![vec![0; n + 1]; m];
        let mut col_sum = vec![vec![0; n]; m + 1];
        let mut diag1 = vec![vec![0; n + 1]; m + 1]; // top-left → bottom-right
        let mut diag2 = vec![vec![0; n + 1]; m + 1]; // top-right → bottom-left

        for i in 0..m {
            for j in 0..n {
                row_sum[i][j + 1] = row_sum[i][j] + grid[i][j];
                col_sum[i + 1][j] = col_sum[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        let max_k = m.min(n);
        for k in (1..=max_k).rev() {
            for i in 0..=m - k {
                for j in 0..=n - k {
                    let d1 = diag1[i + k][j + k] - diag1[i][j];
                    let d2 = diag2[i + k][j] - diag2[i][j + k];
                    if d1 != d2 { continue; }

                    let mut ok = true;
                    for x in 0..k {
                        let rsum = row_sum[i + x][j + k] - row_sum[i + x][j];
                        let csum = col_sum[i + k][j + x] - col_sum[i][j + x];
                        if rsum != d1 || csum != d1 {
                            ok = false;
                            break;
                        }
                    }

                    if ok { return k as i32; }
                }
            }
        }

        1
    }
}