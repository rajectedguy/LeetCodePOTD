long long maxMatrixSum(int** matrix, int matrixSize, int* matrixColSize) {
    long long sum = 0;
    int neg = 0;
    int mn = INT_MAX;
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixColSize[i]; j++) {
            int x = matrix[i][j];
            if (x < 0) neg++;
            sum += llabs(x);
            if (abs(x) < mn) mn = abs(x);
        }
    }
    if (neg % 2) sum -= 2LL * mn;
    return sum;
}