-spec minimum_abs_difference(Arr :: [integer()]) -> [[integer()]].
minimum_abs_difference(Arr) ->
    A = lists:sort(Arr),
    Mn = min_diff(A),
    collect(A, Mn).

min_diff([_]) -> infinity;
min_diff([X, Y | T]) ->
    min(Y - X, min_diff([Y | T])).

collect([_], _) -> [];
collect([X, Y | T], Mn) ->
    case Y - X of
        Mn -> [[X, Y] | collect([Y | T], Mn)];
        _  -> collect([Y | T], Mn)
    end.
