var separateSquares = function(squares) {
    const xs = [];
    const events = [];
    for (const [x, y, l] of squares) {
        xs.push(x, x + l);
        events.push([y, x, x + l, 1]);
        events.push([y + l, x, x + l, -1]);
    }

    xs.sort((a, b) => a - b);
    const uniq = [];
    for (let i = 0; i < xs.length; i++) {
        if (i === 0 || xs[i] !== xs[i - 1]) uniq.push(xs[i]);
    }
    const m = uniq.length;
    const idx = new Map();
    for (let i = 0; i < m; i++) idx.set(uniq[i], i);

    const cnt = new Array(4 * m).fill(0);
    const len = new Array(4 * m).fill(0);

    function upd(i, l, r, ql, qr, v) {
        if (qr <= l || r <= ql) return;
        if (ql <= l && r <= qr) {
            cnt[i] += v;
        } else {
            const mid = (l + r) >> 1;
            upd(i << 1, l, mid, ql, qr, v);
            upd(i << 1 | 1, mid, r, ql, qr, v);
        }
        if (cnt[i] > 0) len[i] = uniq[r] - uniq[l];
        else if (l + 1 === r) len[i] = 0;
        else len[i] = len[i << 1] + len[i << 1 | 1];
    }

    events.sort((a, b) => a[0] - b[0]);

    let prevY = events[0][0];
    let total = 0;
    let i = 0;

    while (i < events.length) {
        const y = events[i][0];
        const dy = y - prevY;
        if (dy > 0 && len[1] > 0) total += len[1] * dy;
        while (i < events.length && events[i][0] === y) {
            const [, x1, x2, t] = events[i];
            upd(1, 0, m - 1, idx.get(x1), idx.get(x2), t);
            i++;
        }
        prevY = y;
    }

    const half = total / 2;
    cnt.fill(0);
    len.fill(0);
    prevY = events[0][0];
    let cur = 0;
    i = 0;

    while (i < events.length) {
        const y = events[i][0];
        const dy = y - prevY;
        if (dy > 0 && len[1] > 0) {
            const area = len[1] * dy;
            if (cur + area >= half) {
                return prevY + (half - cur) / len[1];
            }
            cur += area;
        }
        while (i < events.length && events[i][0] === y) {
            const [, x1, x2, t] = events[i];
            upd(1, 0, m - 1, idx.get(x1), idx.get(x2), t);
            i++;
        }
        prevY = y;
    }

    return prevY;
};