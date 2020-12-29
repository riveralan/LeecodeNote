class Solution {
    /**
     * 解题思路：动态规划
     * 状态转移方程：dp[m][n]代表字符串1，0-m和字符串2，0-n的最长子序列
     * 当m==n时，dp[m-1],dp[n-1]+1即为最长子序列，因为两个都一样，肯定都算进去
     * 否则，dp[m][n] = max{dp[m-1][n],dp[m][n-1]}
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0;i < m; i++){
            for(int j = 0; j<n;j++){
                char c1 = text1.charAt(i),c2 = text2.charAt(j);
                if(c1 == c2){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
