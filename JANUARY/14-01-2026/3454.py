class Solution:
    def separateSquares(self, squares):
        xs = []
        events = []
        for x, y, l in squares:
            xs.append(x)
            xs.append(x + l)
            events.append((y, x, x + l, 1))
            events.append((y + l, x, x + l, -1))

        xs = sorted(set(xs))
        idx = {v: i for i, v in enumerate(xs)}
        m = len(xs)

        cnt = [0] * (4 * m)
        length = [0] * (4 * m)

        def upd(node, l, r, ql, qr, v):
            if qr <= l or r <= ql:
                return
            if ql <= l and r <= qr:
                cnt[node] += v
            else:
                mid = (l + r) // 2
                upd(node * 2, l, mid, ql, qr, v)
                upd(node * 2 + 1, mid, r, ql, qr, v)
            if cnt[node] > 0:
                length[node] = xs[r] - xs[l]
            elif l + 1 == r:
                length[node] = 0
            else:
                length[node] = length[node * 2] + length[node * 2 + 1]

        events.sort()
        prev_y = events[0][0]
        total = 0.0
        i = 0
        n = len(events)

        while i < n:
            y = events[i][0]
            dy = y - prev_y
            if dy > 0 and length[1] > 0:
                total += length[1] * dy
            while i < n and events[i][0] == y:
                _, x1, x2, t = events[i]
                upd(1, 0, m - 1, idx[x1], idx[x2], t)
                i += 1
            prev_y = y

        half = total / 2.0

        cnt = [0] * (4 * m)
        length = [0] * (4 * m)
        prev_y = events[0][0]
        cur = 0.0
        i = 0

        while i < n:
            y = events[i][0]
            dy = y - prev_y
            if dy > 0 and length[1] > 0:
                area = length[1] * dy
                if cur + area >= half:
                    return prev_y + (half - cur) / length[1]
                cur += area
            while i < n and events[i][0] == y:
                _, x1, x2, t = events[i]
                upd(1, 0, m - 1, idx[x1], idx[x2], t)
                i += 1
            prev_y = y

        return float(prev_y)