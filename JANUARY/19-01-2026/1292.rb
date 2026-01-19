# @param {Integer[][]} mat
# @param {Integer} threshold
# @return {Integer}
def max_side_length(mat, threshold)
    m = mat.length
    n = mat[0].length

    prefix = Array.new(m + 1) { Array.new(n + 1, 0) }
    (0...m).each do |i|
        (0...n).each do |j|
            prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]
        end
    end

    left = 0
    right = [m, n].min
    ans = 0

    while left <= right
        mid = (left + right) / 2
        found = false

        (mid..m).each do |i|
            break if found
            (mid..n).each do |j|
                total = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid]
                if total <= threshold
                    found = true
                    break
                end
            end
        end

        if found
            ans = mid
            left = mid + 1
        else
            right = mid - 1
        end
    end

    ans
end