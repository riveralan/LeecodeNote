class Solution {
    /**
    解题思路：
    动态规划
    由题易知，状态方程为：f(n) = f(n-1) + f(n-2),其中f(n)表示该青蛙跳上n级台阶由多少种跳法；
    初始状态为f(1)有一种方案，f(2)有两种方案
    本来直接递归即可，但是后面发现OverFlow了
    由于f(n) 只和f(n-1) + f(n-2)有关，所以设置两个变量保存状态即可
    **/
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        if(n<=2){
            return n;
        }
        int a = 2;//f(n-1)
        int b = 1;//f(n-2)
        int c = 0;
        for(int i = 3;i<=n;i++){
            c = (a+b)%1000000007;
            b=a;
            a=c;
        }
        return c;
    }
}