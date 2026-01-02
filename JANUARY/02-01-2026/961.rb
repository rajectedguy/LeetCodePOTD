# @param {Integer[]} nums
# @return {Integer}
def repeated_n_times(nums)
    set = {}
    nums.each do |x|
        return x if set[x]
        set[x] = true
    end
end