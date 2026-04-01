# @param {Integer[]} arr
# @return {Integer[][]}
def minimum_abs_difference(arr)
  arr.sort!
  mn = arr.each_cons(2).map { |a, b| b - a }.min
  arr.each_cons(2).select { |a, b| b - a == mn }
end