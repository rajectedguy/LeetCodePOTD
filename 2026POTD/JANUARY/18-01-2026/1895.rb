# @param {Integer[][]} grid
# @return {Integer}
def largest_magic_square(grid)
    m = grid.length
    n = grid[0].length


    row_sum = Array.new(m) { Array.new(n+1, 0) }
    col_sum = Array.new(m+1) { Array.new(n, 0) }
    diag1 = Array.new(m+1) { Array.new(n+1, 0) } 
    diag2 = Array.new(m+1) { Array.new(n+1, 0) } 


    (0...m).each do |i|
        (0...n).each do |j|
            row_sum[i][j+1] = row_sum[i][j] + grid[i][j]
            col_sum[i+1][j] = col_sum[i][j] + grid[i][j]
            diag1[i+1][j+1] = diag1[i][j] + grid[i][j]
            diag2[i+1][j] = diag2[i][j+1] + grid[i][j]
        end
    end

    max_k = [m, n].min
    max_k.downto(1) do |k|
        (0..m-k).each do |i|
            (0..n-k).each do |j|
                d1 = diag1[i+k][j+k] - diag1[i][j]
                d2 = diag2[i+k][j] - diag2[i][j+k]
                next if d1 != d2

                ok = true
                (0...k).each do |x|
                    rsum = row_sum[i+x][j+k] - row_sum[i+x][j]
                    csum = col_sum[i+k][j+x] - col_sum[i][j+x]
                    if rsum != d1 || csum != d1
                        ok = false
                        break
                    end
                end

                return k if ok
            end
        end
    end

    return 1
end