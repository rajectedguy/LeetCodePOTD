int maximalRectangle(char** matrix, int matrixSize, int* matrixColSize) {
    if (matrixSize == 0) return 0;

    int cols = matrixColSize[0];
    int* heights = (int*)calloc(cols, sizeof(int));
    int* stack = (int*)malloc((cols + 1) * sizeof(int));
    int ans = 0;

    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < cols; j++) {
            heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
        }

        int top = -1;
        for (int k = 0; k <= cols; k++) {
            int h = (k == cols) ? 0 : heights[k];
            while (top != -1 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = (top == -1) ? k : k - stack[top] - 1;
                int area = height * width;
                if (area > ans) ans = area;
            }
            stack[++top] = k;
        }
    }

    free(heights);
    free(stack);
    return ans;
}