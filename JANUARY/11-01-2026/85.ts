function maximalRectangle(matrix: string[][]): number {
    if (matrix.length === 0) return 0;

    const cols = matrix[0].length;
    const heights: number[] = new Array(cols).fill(0);
    let ans = 0;

    for (const row of matrix) {
        for (let j = 0; j < cols; j++) {
            heights[j] = row[j] === '1' ? heights[j] + 1 : 0;
        }

        const stack: number[] = [];
        for (let i = 0; i <= cols; i++) {
            const h = i === cols ? 0 : heights[i];
            while (stack.length && h < heights[stack[stack.length - 1]]) {
                const height = heights[stack.pop()!];
                const width = stack.length ? i - stack[stack.length - 1] - 1 : i;
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
    }

    return ans;
}