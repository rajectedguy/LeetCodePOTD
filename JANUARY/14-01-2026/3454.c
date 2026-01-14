#include <stdlib.h>
#include <string.h>

static int cmp_ll(const void *a, const void *b) {
    long long x = *(const long long*)a;
    long long y = *(const long long*)b;
    return (x > y) - (x < y);
}

static int cmp_ev(const void *a, const void *b) {
    long long x = ((long long*)a)[0];
    long long y = ((long long*)b)[0];
    return (x > y) - (x < y);
}

static int lower_bound_ll(long long *arr, int n, long long val) {
    int l = 0, r = n;
    while (l < r) {
        int m = (l + r) >> 1;
        if (arr[m] < val) l = m + 1;
        else r = m;
    }
    return l;
}

long long *xs, *cnt, *seglen;

void upd(int i, int l, int r, int ql, int qr, long long v) {
    if (qr <= l || r <= ql) return;
    if (ql <= l && r <= qr) {
        cnt[i] += v;
    } else {
        int m = (l + r) >> 1;
        upd(i<<1, l, m, ql, qr, v);
        upd(i<<1|1, m, r, ql, qr, v);
    }
    if (cnt[i] > 0) seglen[i] = xs[r] - xs[l];
    else if (l + 1 == r) seglen[i] = 0;
    else seglen[i] = seglen[i<<1] + seglen[i<<1|1];
}

double separateSquares(int** squares, int squaresSize, int* squaresColSize) {
    int n = squaresSize;
    xs = malloc(sizeof(long long) * 2 * n);
    long long (*ev)[4] = malloc(sizeof(long long) * 4 * 2 * n);

    for (int i = 0; i < n; i++) {
        long long x = squares[i][0];
        long long y = squares[i][1];
        long long l = squares[i][2];
        xs[2*i] = x;
        xs[2*i+1] = x + l;
        ev[2*i][0] = y;
        ev[2*i][1] = x;
        ev[2*i][2] = x + l;
        ev[2*i][3] = 1;
        ev[2*i+1][0] = y + l;
        ev[2*i+1][1] = x;
        ev[2*i+1][2] = x + l;
        ev[2*i+1][3] = -1;
    }

    qsort(xs, 2*n, sizeof(long long), cmp_ll);
    int m = 0;
    for (int i = 0; i < 2*n; i++)
        if (i == 0 || xs[i] != xs[i-1]) xs[m++] = xs[i];

    qsort(ev, 2*n, sizeof(ev[0]), cmp_ev);

    cnt = calloc(4*m, sizeof(long long));
    seglen = calloc(4*m, sizeof(long long));

    long long prev = ev[0][0];
    double total = 0;
    int i = 0;

    while (i < 2*n) {
        long long y = ev[i][0];
        long long dy = y - prev;
        if (dy > 0 && seglen[1] > 0)
            total += seglen[1] * (double)dy;

        while (i < 2*n && ev[i][0] == y) {
            int l = lower_bound_ll(xs, m, ev[i][1]);
            int r = lower_bound_ll(xs, m, ev[i][2]);
            upd(1, 0, m, l, r, ev[i][3]);
            i++;
        }
        prev = y;
    }

    double half = total / 2.0;

    memset(cnt, 0, sizeof(long long) * 4 * m);
    memset(seglen, 0, sizeof(long long) * 4 * m);

    prev = ev[0][0];
    double cur = 0;
    i = 0;

    while (i < 2*n) {
        long long y = ev[i][0];
        long long dy = y - prev;
        if (dy > 0 && seglen[1] > 0) {
            double area = seglen[1] * (double)dy;
            if (cur + area >= half)
                return prev + (half - cur) / seglen[1];
            cur += area;
        }
        while (i < 2*n && ev[i][0] == y) {
            int l = lower_bound_ll(xs, m, ev[i][1]);
            int r = lower_bound_ll(xs, m, ev[i][2]);
            upd(1, 0, m, l, r, ev[i][3]);
            i++;
        }
        prev = y;
    }

    return prev;
}