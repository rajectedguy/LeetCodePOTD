impl Solution {
    pub fn max_matrix_sum(matrix: Vec<Vec<i32>>) -> i64 {
        let mut sum: i64 = 0;
        let mut neg = 0;
        let mut mn: i64 = i64::MAX;
        for row in matrix {
            for x in row {
                if x < 0 {
                    neg += 1;
                }
                let ax = (x as i64).abs();
                sum += ax;
                if ax < mn {
                    mn = ax;
                }
            }
        }
        if neg % 2 == 1 {
            sum -= 2 * mn;
        }
        sum
    }
}