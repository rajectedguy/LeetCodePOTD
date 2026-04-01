# @param {Integer[]} nums
# @return {Integer}
def sum_four_divisors(nums)
  ans = 0

  nums.each do |x|
    n = x
    p = q = cnt = 0

    i = 2
    while i * i <= n && cnt <= 2
      if n % i == 0
        cnt += 1
        cnt == 1 ? p = i : q = i
        n /= i while n % i == 0
      end
      i += 1
    end

    if n > 1
      cnt += 1
      cnt == 1 ? p = n : q = n
    end

    if cnt == 2 && p * q == x
      ans += 1 + p + q + x
    elsif cnt == 1 && p * p * p == x
      ans += 1 + p + p * p + x
    end
  end

  ans
end