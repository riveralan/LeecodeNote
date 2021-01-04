public class UniquePathsWithObstacles {
    /**
     解题思路：动态规划
     dp[m][n]=dp[m-1][n]+dp[m][n-1]
     若obstacleGrid[m-2][n-1]或obstacleGrid[m-1][n-2]为1，则dp[m-1][n]或dp[m][n-1]置0
     dp为最大不同路径
     初始状态：dp[1][*]，dp[*][1]为1，因为只能向下或者向右移动一步
     最终答案为d[m][n]
     **/
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1,flag = 1; i <= m ; i++){
            if(obstacleGrid[i-1][0]==1){
                flag = 0;
            }
            dp[i][1] = flag;
        }
        for(int j = 1,flag = 1; j <= n ; j++){
            if(obstacleGrid[0][j-1]==1){
                flag = 0;
            }
            dp[1][j] = flag;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i+1][j+1] = 0;
                }
            }
        }
        for(int i = 2;i <= m; i++){
            for(int j = 2;j <= n; j++){
                if(obstacleGrid[i-1][j-1]==1){
                    continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int [][] obstacleGrid = new int[][]
                {
                        {1,0}
                };
        int result = UniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}
