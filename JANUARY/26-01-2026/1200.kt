class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        var mn = Int.MAX_VALUE
        for (i in 1 until arr.size)
            mn = minOf(mn, arr[i] - arr[i - 1])

        val res = ArrayList<List<Int>>()
        for (i in 1 until arr.size)
            if (arr[i] - arr[i - 1] == mn)
                res.add(listOf(arr[i - 1], arr[i]))
        return res
    }
}