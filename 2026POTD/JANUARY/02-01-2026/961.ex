defmodule Solution do
  @spec repeated_n_times(nums :: [integer]) :: integer
  def repeated_n_times(nums) do
    Enum.reduce_while(nums, MapSet.new(), fn x, set ->
      if MapSet.member?(set, x) do
        {:halt, x}
      else
        {:cont, MapSet.put(set, x)}
      end
    end)
  end
end