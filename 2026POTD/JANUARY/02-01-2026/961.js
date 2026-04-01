/**
 * @param {number[]} nums
 * @return {number}
 */
var repeatedNTimes = function(nums) {
    const set = new Set();
    for (const x of nums) {
        if (set.has(x)) return x;
        set.add(x);
    }
};