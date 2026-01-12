def min_time_to_visit_all_points(points)
  ans = 0
  (1...points.length).each do |i|
    dx = (points[i][0] - points[i - 1][0]).abs
    dy = (points[i][1] - points[i - 1][1]).abs
    ans += [dx, dy].max
  end
  ans
end