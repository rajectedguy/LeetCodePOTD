#include <vector>
#include <set>
#include <numeric>
#include <algorithm>

using namespace std;

class Solution {
    long long current_sum = 0;
    multiset<int> left_set, right_set;
    int max_size;

    void balance() {
        while (left_set.size() < max_size && !right_set.empty()) {
            int val = *right_set.begin();
            current_sum += val;
            left_set.insert(val);
            right_set.erase(right_set.begin());
        }
        while (left_set.size() > max_size) {
            int val = *left_set.rbegin();
            current_sum -= val;
            right_set.insert(val);
            left_set.erase(prev(left_set.end()));
        }
    }

    void add(int val) {
        if (!left_set.empty() && val < *left_set.rbegin()) {
            current_sum += val;
            left_set.insert(val);
        } else {
            right_set.insert(val);
        }
        balance();
    }

    void remove(int val) {
        auto it = left_set.find(val);
        if (it != left_set.end()) {
            current_sum -= val;
            left_set.erase(it);
        } else {
            right_set.erase(right_set.find(val));
        }
        balance();
    }

public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        int n = nums.size();
        max_size = k - 2;
        current_sum = 0;
        left_set.clear();
        right_set.clear();

        for (int i = 2; i <= dist + 1; ++i) {
            add(nums[i]);
        }

        long long min_cost = nums[0] + nums[1] + current_sum;

        for (int i = 2; i <= n - (k - 1); ++i) {
            remove(nums[i]);
            if (i + dist < n) {
                add(nums[i + dist]);
            }
            min_cost = min(min_cost, (long long)nums[0] + nums[i] + current_sum);
        }

        return min_cost;
    }
};