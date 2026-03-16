class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int max = Math.min(n / 2, m / 2);
        int[] res = new int[3];
        int[][] pf1 = new int[n][m];
        int[][] pf2 = new int[n][m];
        pf1[0] = grid[0];
        pf2[0] = grid[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m - 1; j++){
                pf1[i][j] = pf1[i - 1][j + 1] + grid[i][j];
            }
            for(int j = 1; j < m; j++){
                pf2[i][j] = pf2[i - 1][j - 1] + grid[i][j];
            }
        }
        for(int len = 0; len <= max; len++){
            for(int i = 0; i < n - 2 * len; i++){
                for(int j = len; j < m - len; j++){
                    int curr = grid[i][j];
                    if(len > 0){
                        curr += pf2[i + len][j + len] - pf2[i][j];
                        curr += pf1[i + len][j - len] - pf1[i][j];
                        curr += pf1[i + 2 * len][j] - pf1[i + len][j + len];
                        curr += pf2[i + 2 * len][j] - pf2[i + len][j - len];
                        curr -= grid[i + 2 * len][j];
                    }
                    if(curr >= res[0]){
                        if(curr == res[0]){
                            continue;
                        }
                        res[2] = res[1];
                        res[1] = res[0];
                        res[0] = curr;
                    }else if(curr >= res[1]){
                        if(curr == res[1]){
                            continue;
                        }
                        res[2] = res[1];
                        res[1] = curr;
                    }else if(curr > res[2]){
                        res[2] = curr;
                    }
                }
            }
        }
        int idx = 1;
        for(int i = 1; i < 3; i++){
            if(res[i] == 0 || res[i] == res[i - 1]){
                break;
            }
            idx++;
        }
        int[] fres = new int[idx];
        for(int i = 0; i < idx; i++){
            fres[i] = res[i];
        }
        return fres;
    }
}