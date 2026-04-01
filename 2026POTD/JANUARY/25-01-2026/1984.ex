defmodule Solution do
  @spec minimum_difference(nums :: [integer], k :: integer) :: integer
  def minimum_difference(nums, k) do
    if k <= 1 do
      0
    else
      nums = Enum.sort(nums)
      nums
      |> Enum.chunk_every(k, 1, :discard)
      |> Enum.map(fn chunk -> List.last(chunk) - hd(chunk) end)
      |> Enum.min()
    end
  end
end