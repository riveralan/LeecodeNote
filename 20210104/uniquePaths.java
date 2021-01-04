public class UniquePaths{
/**
    解题思路：动态规划
    dp[m][n]=dp[m-1][n]+dp[m][n-1]
    dp为最大不同路径
    初始状态：dp[1][*]，dp[*][1]为1，因为只能向下或者向右移动一步
    最终答案为d[m][n]
    **/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m ; i++){
            dp[i][1] = 1;
        }
        for(int j = 1; j <= n ; j++){
            dp[1][j] = 1;
        }
        for(int i = 2;i <= m; i++){
            for(int j = 2;j <= n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}