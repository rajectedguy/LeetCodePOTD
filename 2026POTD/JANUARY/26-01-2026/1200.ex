defmodule Solution do
  @spec minimum_abs_difference(arr :: [integer]) :: [[integer]]
  def minimum_abs_difference(arr) do
    a = Enum.sort(arr)
    mn =
      a
      |> Enum.chunk_every(2, 1, :discard)
      |> Enum.map(fn [x, y] -> y - x end)
      |> Enum.min()

    a
    |> Enum.chunk_every(2, 1, :discard)
    |> Enum.filter(fn [x, y] -> y - x == mn end)
  end
end