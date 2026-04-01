impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        if matrix.is_empty() {
            return 0;
        }

        let cols = matrix[0].len();
        let mut heights = vec![0; cols];
        let mut ans = 0;

        for row in matrix {
            for j in 0..cols {
                heights[j] = if row[j] == '1' { heights[j] + 1 } else { 0 };
            }

            let mut stack: Vec<usize> = Vec::new();
            for i in 0..=cols {
                let h = if i == cols { 0 } else { heights[i] };
                while let Some(&top) = stack.last() {
                    if h >= heights[top] {
                        break;
                    }
                    let height = heights[top];
                    stack.pop();
                    let width = if let Some(&prev) = stack.last() {
                        i - prev - 1
                    } else {
                        i
                    };
                    ans = ans.max((height * width) as i32);
                }
                stack.push(i);
            }
        }

        ans
    }
}