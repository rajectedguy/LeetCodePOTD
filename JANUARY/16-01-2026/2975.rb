def maximize_square_area(m, n, h_fences, v_fences)
  mod = 1_000_000_007

  h = h_fences + [1, m]
  v = v_fences + [1, n]

  h.sort!
  v.sort!

  hs = {}
  (0...h.length).each do |i|
    (i + 1...h.length).each do |j|
      hs[h[j] - h[i]] = true
    end
  end

  best = -1
  (0...v.length).each do |i|
    (i + 1...v.length).each do |j|
      d = v[j] - v[i]
      if hs[d]
        best = [best, d].max
      end
    end
  end

  return -1 if best == -1
  (best * best) % mod
end