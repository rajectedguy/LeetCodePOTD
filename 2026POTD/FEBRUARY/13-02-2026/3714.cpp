#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.length();
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s[i] == s[i-1]) count++;
            else count = 1;
            maxLen = max(maxLen, count);
        }

        maxLen = max(maxLen, solveTwo(s, 'a', 'b'));
        maxLen = max(maxLen, solveTwo(s, 'b', 'c'));
        maxLen = max(maxLen, solveTwo(s, 'a', 'c'));
        maxLen = max(maxLen, solveThree(s));

        return maxLen;
    }

private:
    int solveTwo(string& s, char c1, char c2) {
        unordered_map<int, int> first_occurence;
        first_occurence[0] = -1;
        int diff = 0, res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == c1) diff++;
            else if (s[i] == c2) diff--;
            else {
                first_occurence.clear();
                first_occurence[0] = i;
                diff = 0;
                continue;
            }
            
            if (first_occurence.count(diff)) {
                res = max(res, i - first_occurence[diff]);
            } else {
                first_occurence[diff] = i;
            }
        }
        return res;
    }

    int solveThree(string& s) {
        struct pair_hash {
            inline size_t operator()(const pair<int, int> & v) const {
                return v.first * 31 + v.second;
            }
        };
        
        unordered_map<pair<int, int>, int, pair_hash> first_occurence;
        first_occurence[{0, 0}] = -1;
        int a = 0, b = 0, c = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'a') a++;
            else if (s[i] == 'b') b++;
            else if (s[i] == 'c') c++;

            pair<int, int> key = {a - b, b - c};
            if (first_occurence.count(key)) {
                res = max(res, i - first_occurence[key]);
            } else {
                first_occurence[key] = i;
            }
        }
        return res;
    }
};