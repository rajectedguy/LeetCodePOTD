# @param {Integer[][]} matrix
# @return {Integer}
def max_matrix_sum(matrix)
    sum = 0
    neg = 0
    mn = Float::INFINITY
    matrix.each do |row|
        row.each do |x|
            neg += 1 if x < 0
            ax = x.abs
            sum += ax
            mn = [mn, ax].min
        end
    end
    sum -= 2 * mn if neg.odd?
    sum
end