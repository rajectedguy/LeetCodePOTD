function minimumAbsDifference(arr: number[]): number[][] {
    arr.sort((a, b) => a - b);
    let mn = Infinity;
    for (let i = 1; i < arr.length; i++)
        mn = Math.min(mn, arr[i] - arr[i - 1]);

    let res: number[][] = [];
    for (let i = 1; i < arr.length; i++)
        if (arr[i] - arr[i - 1] === mn)
            res.push([arr[i - 1], arr[i]]);
    return res;
}