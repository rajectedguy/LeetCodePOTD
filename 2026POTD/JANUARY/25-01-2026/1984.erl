-spec minimum_difference(Nums :: [integer()], K :: integer()) -> integer().
minimum_difference(Nums, K) when K =< 1 ->
    0;
minimum_difference(Nums, K) ->
    Sorted = lists:sort(Nums),
    Diffs = [lists:nth(I + K - 1, Sorted) - lists:nth(I, Sorted)
             || I <- lists:seq(1, length(Sorted) - K + 1)],
    lists:min(Diffs).