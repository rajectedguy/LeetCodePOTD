# @param {Integer[][]} squares
# @return {Float}
def separate_squares(squares)
  xs = []
  events = []

  squares.each do |x, y, l|
    xs << x
    xs << x + l
    events << [y, x, x + l, 1]
    events << [y + l, x, x + l, -1]
  end

  xs.sort!.uniq!
  m = xs.length
  idx = {}
  xs.each_with_index { |v, i| idx[v] = i }

  cnt = Array.new(4 * m, 0)
  seglen = Array.new(4 * m, 0)

  update = lambda do |i, l, r, ql, qr, v|
    next if qr <= l || r <= ql
    if ql <= l && r <= qr
      cnt[i] += v
    else
      mid = (l + r) / 2
      update.call(i * 2, l, mid, ql, qr, v)
      update.call(i * 2 + 1, mid, r, ql, qr, v)
    end
    if cnt[i] > 0
      seglen[i] = xs[r] - xs[l]
    elsif l + 1 == r
      seglen[i] = 0
    else
      seglen[i] = seglen[i * 2] + seglen[i * 2 + 1]
    end
  end

  events.sort_by!(&:first)

  prev = events[0][0]
  total = 0.0
  i = 0

  while i < events.length
    y = events[i][0]
    dy = y - prev
    total += seglen[1] * dy if dy > 0 && seglen[1] > 0

    while i < events.length && events[i][0] == y
      _, x1, x2, t = events[i]
      update.call(1, 0, m, idx[x1], idx[x2], t)
      i += 1
    end
    prev = y
  end

  half = total / 2.0
  cnt.fill(0)
  seglen.fill(0)

  prev = events[0][0]
  cur = 0.0
  i = 0

  while i < events.length
    y = events[i][0]
    dy = y - prev
    if dy > 0 && seglen[1] > 0
      area = seglen[1] * dy
      return prev + (half - cur) / seglen[1] if cur + area >= half
      cur += area
    end

    while i < events.length && events[i][0] == y
      _, x1, x2, t = events[i]
      update.call(1, 0, m, idx[x1], idx[x2], t)
      i += 1
    end
    prev = y
  end

  prev.to_f
end