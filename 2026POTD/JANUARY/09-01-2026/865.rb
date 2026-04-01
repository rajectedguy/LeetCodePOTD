def subtree_with_all_deepest(root)
  dfs = lambda do |node|
    return [0, nil] if node.nil?
    ld, ln = dfs.call(node.left)
    rd, rn = dfs.call(node.right)
    return [ld + 1, ln] if ld > rd
    return [rd + 1, rn] if rd > ld
    [ld + 1, node]
  end

  dfs.call(root)[1]
end