class Solution {
public:
    int longestBalanced(string s) {
        
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            vector<int> freq(26, 0);

            for (int j = i; j < n; j++) {

                freq[s[j] - 'a']++;

                int count = 0;
                int distinct = 0;
                bool balanced = true;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        distinct++;

                        if (count == 0)
                            count = freq[k];
                        else if (freq[k] != count) {
                            balanced = false;
                            break;
                        }
                    }
                }

                if (balanced) {
                    int len = j - i + 1;
                    maxLen = max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
};