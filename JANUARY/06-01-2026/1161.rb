def max_level_sum(root)
    q = [root]
    level = 1
    ans = 1
    max_sum = -Float::INFINITY

    while !q.empty?
        size = q.size
        sum = 0

        size.times do
            node = q.shift
            sum += node.val
            q << node.left if node.left
            q << node.right if node.right
        end

        if sum > max_sum
            max_sum = sum
            ans = level
        end
        level += 1
    end

    ans
end