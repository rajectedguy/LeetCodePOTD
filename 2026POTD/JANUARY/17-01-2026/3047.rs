impl Solution {
    pub fn largest_square_area(bottom_left: Vec<Vec<i32>>, top_right: Vec<Vec<i32>>) -> i64 {
        let n = bottom_left.len();
        let mut ans: i64 = 0;
        for i in 0..n {
            for j in (i + 1)..n {
                let x1 = bottom_left[i][0].max(bottom_left[j][0]);
                let y1 = bottom_left[i][1].max(bottom_left[j][1]);
                let x2 = top_right[i][0].min(top_right[j][0]);
                let y2 = top_right[i][1].min(top_right[j][1]);
                if x2 > x1 && y2 > y1 {
                    let side = (x2 - x1).min(y2 - y1) as i64;
                    let area = side * side;
                    if area > ans {
                        ans = area;
                    }
                }
            }
        }
        ans
    }
}