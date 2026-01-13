def separate_squares(squares)
  events = []
  squares.each do |_, y, l|
    events << [y.to_f, l.to_f]
    events << [(y + l).to_f, -l.to_f]
  end

  events.sort_by!(&:first)

  segments = []
  cur_width = 0.0
  prev_y = events[0][0]
  total_area = 0.0

  events.each do |y, delta|
    if y > prev_y && cur_width > 0
      area = (y - prev_y) * cur_width
      segments << [prev_y, y, cur_width, area]
      total_area += area
    end
    cur_width += delta
    prev_y = y
  end

  target = total_area / 2.0
  acc = 0.0

  segments.each do |y1, y2, w, area|
    if acc + area >= target
      return y1 + (target - acc) / w
    end
    acc += area
  end

  0.0
end