# @param {Integer[]} nums
# @return {Integer}
def min_pair_sum(nums)
  nums.sort!
  i = 0
  j = nums.length - 1
  ans = 0
  while i < j
    ans = [ans, nums[i] + nums[j]].max
    i += 1
    j -= 1
  end
  ans
end