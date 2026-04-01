function maxMatrixSum(matrix: number[][]): number {
    let sum = 0;
    let neg = 0;
    let mn = Infinity;
    for (const row of matrix) {
        for (const x of row) {
            if (x < 0) neg++;
            sum += Math.abs(x);
            mn = Math.min(mn, Math.abs(x));
        }
    }
    if (neg % 2 === 1) sum -= 2 * mn;
    return sum;
}