# @param {Integer} n
# @param {Integer} m
# @param {Integer[]} h_bars
# @param {Integer[]} v_bars
# @return {Integer}
def maximize_square_hole_area(n, m, h_bars, v_bars)
  longest = lambda do |a|
    a.sort!
    best = cur = 1
    (1...a.length).each do |i|
      if a[i] == a[i - 1] + 1
        cur += 1
      else
        cur = 1
      end
      best = cur if cur > best
    end
    best + 1
  end

  side = [longest.call(h_bars), longest.call(v_bars)].min
  side * side
end