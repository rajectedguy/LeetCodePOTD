var separateSquares = function(squares) {
    let lo = 1e18, hi = -1e18;
    let total = 0.0;
    for (const s of squares) {
        const y = s[1], l = s[2];
        if (y < lo) lo = y;
        if (y + l > hi) hi = y + l;
        total += l * l;
    }
    const target = total / 2.0;
    for (let it = 0; it < 80; it++) {
        const mid = (lo + hi) * 0.5;
        let below = 0.0;
        for (const s of squares) {
            const y = s[1], l = s[2];
            if (mid > y) {
                let h = mid - y;
                if (h > l) h = l;
                below += h * l;
            }
        }
        if (below < target) lo = mid;
        else hi = mid;
    }
    return lo;
};