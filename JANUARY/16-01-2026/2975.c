#include <stdlib.h>

int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int maximizeSquareArea(int m, int n, int* hFences, int hFencesSize, int* vFences, int vFencesSize) {
    const long long MOD = 1000000007LL;

    int hs = hFencesSize + 2;
    int vs = vFencesSize + 2;

    int* h = malloc(sizeof(int) * hs);
    int* v = malloc(sizeof(int) * vs);

    h[0] = 1; h[1] = m;
    v[0] = 1; v[1] = n;

    for (int i = 0; i < hFencesSize; i++) h[i + 2] = hFences[i];
    for (int i = 0; i < vFencesSize; i++) v[i + 2] = vFences[i];

    qsort(h, hs, sizeof(int), cmp);
    qsort(v, vs, sizeof(int), cmp);

    int hCnt = hs * (hs - 1) / 2;
    int* hd = malloc(sizeof(int) * hCnt);
    int idx = 0;

    for (int i = 0; i < hs; i++)
        for (int j = i + 1; j < hs; j++)
            hd[idx++] = h[j] - h[i];

    qsort(hd, hCnt, sizeof(int), cmp);

    long long best = -1;
    for (int i = 0; i < vs; i++) {
        for (int j = i + 1; j < vs; j++) {
            int d = v[j] - v[i];
            if (bsearch(&d, hd, hCnt, sizeof(int), cmp))
                if (d > best) best = d;
        }
    }

    free(h);
    free(v);
    free(hd);

    if (best == -1) return -1;
    return (int)((best * best) % MOD);
}