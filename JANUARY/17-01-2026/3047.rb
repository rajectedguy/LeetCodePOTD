# @param {Integer[][]} bottom_left
# @param {Integer[][]} top_right
# @return {Integer}
def largest_square_area(bottom_left, top_right)
  n = bottom_left.length
  ans = 0
  (0...n).each do |i|
    (i + 1...n).each do |j|
      x1 = [bottom_left[i][0], bottom_left[j][0]].max
      y1 = [bottom_left[i][1], bottom_left[j][1]].max
      x2 = [top_right[i][0], top_right[j][0]].min
      y2 = [top_right[i][1], top_right[j][1]].min
      if x2 > x1 && y2 > y1
        side = [x2 - x1, y2 - y1].min
        ans = [ans, side * side].max
      end
    end
  end
  ans
end