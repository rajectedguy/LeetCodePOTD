int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int** minimumAbsDifference(int* arr, int arrSize, int* returnSize, int** returnColumnSizes) {
    qsort(arr, arrSize, sizeof(int), cmp);
    int mn = INT_MAX;
    for (int i = 1; i < arrSize; i++)
        if (arr[i] - arr[i - 1] < mn)
            mn = arr[i] - arr[i - 1];

    int count = 0;
    for (int i = 1; i < arrSize; i++)
        if (arr[i] - arr[i - 1] == mn)
            count++;

    int** res = (int**)malloc(sizeof(int*) * count);
    *returnColumnSizes = (int*)malloc(sizeof(int) * count);
    *returnSize = count;

    int idx = 0;
    for (int i = 1; i < arrSize; i++) {
        if (arr[i] - arr[i - 1] == mn) {
            res[idx] = (int*)malloc(sizeof(int) * 2);
            res[idx][0] = arr[i - 1];
            res[idx][1] = arr[i];
            (*returnColumnSizes)[idx] = 2;
            idx++;
        }
    }
    return res;
}