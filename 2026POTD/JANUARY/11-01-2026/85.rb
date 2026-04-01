def maximal_rectangle(matrix)
    return 0 if matrix.empty?

    cols = matrix[0].length
    heights = Array.new(cols, 0)
    ans = 0

    matrix.each do |row|
        (0...cols).each do |j|
            heights[j] = row[j] == '1' ? heights[j] + 1 : 0
        end

        stack = []
        (0..cols).each do |i|
            h = (i == cols) ? 0 : heights[i]
            while !stack.empty? && h < heights[stack[-1]]
                height = heights[stack.pop]
                width = stack.empty? ? i : i - stack[-1] - 1
                ans = [ans, height * width].max
            end
            stack << i
        end
    end

    ans
end