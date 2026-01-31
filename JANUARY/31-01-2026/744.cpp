class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        char ans = '#';
        int start = 0, end = letters.size() - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (letters[mid] > target) {
                ans = letters[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (ans == '#') ? letters[0] : ans;
    }
};