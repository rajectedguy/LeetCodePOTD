class Solution {
    func separateSquares(_ squares: [[Int]]) -> Double {
        let n = squares.count

        var xs = [Int64]()
        xs.reserveCapacity(2 * n)

        struct Event {
            let y: Int64
            let x1: Int64
            let x2: Int64
            let t: Int
        }

        var events = [Event]()
        events.reserveCapacity(2 * n)

        for s in squares {
            let x = Int64(s[0])
            let y = Int64(s[1])
            let l = Int64(s[2])
            xs.append(x)
            xs.append(x + l)
            events.append(Event(y: y, x1: x, x2: x + l, t: 1))
            events.append(Event(y: y + l, x1: x, x2: x + l, t: -1))
        }

        xs.sort()
        var uniq = [Int64]()
        for v in xs {
            if uniq.isEmpty || uniq.last! != v {
                uniq.append(v)
            }
        }

        let m = uniq.count
        var index = [Int64: Int]()
        for i in 0..<m {
            index[uniq[i]] = i
        }

        var cnt = Array(repeating: Int64(0), count: 4 * m)
        var seglen = Array(repeating: Int64(0), count: 4 * m)

        func update(_ i: Int, _ l: Int, _ r: Int, _ ql: Int, _ qr: Int, _ v: Int) {
            if qr <= l || r <= ql { return }
            if ql <= l && r <= qr {
                cnt[i] += Int64(v)
            } else {
                let mid = (l + r) >> 1
                update(i << 1, l, mid, ql, qr, v)
                update(i << 1 | 1, mid, r, ql, qr, v)
            }
            if cnt[i] > 0 {
                seglen[i] = uniq[r] - uniq[l]
            } else if l + 1 == r {
                seglen[i] = 0
            } else {
                seglen[i] = seglen[i << 1] + seglen[i << 1 | 1]
            }
        }

        events.sort { $0.y < $1.y }

        var prevY = events[0].y
        var total = 0.0
        var i = 0

        while i < events.count {
            let y = events[i].y
            let dy = y - prevY
            if dy > 0 && seglen[1] > 0 {
                total += Double(seglen[1]) * Double(dy)
            }
            while i < events.count && events[i].y == y {
                let e = events[i]
                update(1, 0, m, index[e.x1]!, index[e.x2]!, e.t)
                i += 1
            }
            prevY = y
        }

        let half = total / 2.0
        cnt = Array(repeating: 0, count: 4 * m)
        seglen = Array(repeating: 0, count: 4 * m)

        prevY = events[0].y
        var cur = 0.0
        i = 0

        while i < events.count {
            let y = events[i].y
            let dy = y - prevY
            if dy > 0 && seglen[1] > 0 {
                let area = Double(seglen[1]) * Double(dy)
                if cur + area >= half {
                    return Double(prevY) + (half - cur) / Double(seglen[1])
                }
                cur += area
            }
            while i < events.count && events[i].y == y {
                let e = events[i]
                update(1, 0, m, index[e.x1]!, index[e.x2]!, e.t)
                i += 1
            }
            prevY = y
        }

        return Double(prevY)
    }
}