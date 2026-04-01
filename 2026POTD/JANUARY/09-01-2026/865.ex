defmodule Solution do
  @spec subtree_with_all_deepest(root :: TreeNode.t | nil) :: TreeNode.t | nil
  def subtree_with_all_deepest(root) do
    dfs = fn dfs, node ->
      if node == nil do
        {0, nil}
      else
        {ld, ln} = dfs.(dfs, node.left)
        {rd, rn} = dfs.(dfs, node.right)
        cond do
          ld > rd -> {ld + 1, ln}
          rd > ld -> {rd + 1, rn}
          true -> {ld + 1, node}
        end
      end
    end

    {_, result} = dfs.(dfs, root)
    result
  end
end