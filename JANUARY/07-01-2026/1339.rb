def max_product(root)
  mod = 1_000_000_007
  @best = 0

  def sum(node)
    return 0 unless node
    node.val + sum(node.left) + sum(node.right)
  end

  total = sum(root)

  def dfs(node, total)
    return 0 unless node
    s = node.val + dfs(node.left, total) + dfs(node.right, total)
    @best = [@best, s * (total - s)].max
    s
  end

  dfs(root, total)
  @best % mod
end