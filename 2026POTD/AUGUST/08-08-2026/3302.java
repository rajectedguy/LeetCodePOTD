class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] nxtIdx = new int[n + 1][26];

        for(int i = 0; i <= n; i++){
            java.util.Arrays.fill(nxtIdx[i], -1);
        }

        for(int i = n - 1; i >= 0; i--){
            nxtIdx[i] = nxtIdx[i + 1].clone();
            nxtIdx[i][word1.charAt(i) - 'a'] = i;
        }

        int[] suff = new int[m];
        java.util.Arrays.fill(suff, -1);

        int k = m - 1;

        for(int i = n - 1; i >= 0 && k >= 0; i--){
            if(word1.charAt(i) == word2.charAt(k)){
                suff[k] = i;
                k--;
            }
        }

        java.util.ArrayList<Integer> ans = new java.util.ArrayList<>();

        int i = 0;
        int j = 0;
        boolean Used = false;

        while(i < n && j < m){
            int idx = nxtIdx[i][word2.charAt(j) - 'a'];

            if(Used){
                if(idx == -1)
                    return new int[0];

                if(j < m - 1 && suff[j + 1] <= idx)
                    return new int[0];

                ans.add(idx);
                i = idx + 1;
                j++;
            }
            else{
                if(word1.charAt(i) == word2.charAt(j)){
                    ans.add(i);
                    i++;
                    j++;
                }
                else if(j == m - 1 ||
                        (suff[j + 1] != -1 && i < suff[j + 1])){
                    Used = true;
                    ans.add(i);
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
        }

        if(ans.size() != m)
            return new int[0];

        int[] result = new int[m];

        for(int x = 0; x < m; x++){
            result[x] = ans.get(x);
        }

        return result;
    }
};