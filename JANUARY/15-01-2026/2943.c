int cmp(const void* a, const void* b) {
    return (*(int*)a) - (*(int*)b);
}

int longest(int* a, int size) {
    qsort(a, size, sizeof(int), cmp);
    int best = 1, cur = 1;
    for (int i = 1; i < size; i++) {
        if (a[i] == a[i - 1] + 1) cur++;
        else cur = 1;
        if (cur > best) best = cur;
    }
    return best + 1;
}

int maximizeSquareHoleArea(int n, int m, int* hBars, int hBarsSize, int* vBars, int vBarsSize) {
    int h = longest(hBars, hBarsSize);
    int v = longest(vBars, vBarsSize);
    int side = h < v ? h : v;
    return side * side;
}