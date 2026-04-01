defmodule Solution do
  @spec plus_one(digits :: [integer]) :: [integer]
  def plus_one(digits) do
    digits
    |> Enum.reverse()
    |> do_plus_one()
    |> Enum.reverse()
  end

  defp do_plus_one([]), do: [1]

  defp do_plus_one([h | t]) when h < 9 do
    [h + 1 | t]
  end

  defp do_plus_one([_h | t]) do
    [0 | do_plus_one(t)]
  end
end