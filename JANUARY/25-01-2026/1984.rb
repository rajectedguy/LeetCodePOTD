# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def minimum_difference(nums, k)
  return 0 if k <= 1
  nums.sort!
  ans = Float::INFINITY
  (0..nums.length - k).each do |i|
    ans = [ans, nums[i + k - 1] - nums[i]].min
  end
  ans
end