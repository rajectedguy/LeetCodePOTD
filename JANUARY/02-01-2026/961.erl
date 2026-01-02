-spec repeated_n_times(Nums :: [integer()]) -> integer().
repeated_n_times(Nums) ->
    repeated_n_times(Nums, #{ }).

repeated_n_times([], _) ->
    -1;
repeated_n_times([H | T], Set) ->
    case maps:is_key(H, Set) of
        true -> H;
        false -> repeated_n_times(T, maps:put(H, true, Set))
    end.