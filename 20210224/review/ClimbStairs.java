public class ClimbStairs {
    public int climbStairs(int n) {
        int n1 =1,n2 =2,sum = 0;
        if(n<=2){
            return n;
        }
        for(int i = 1;i<=n;i++){
            sum = n1+n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        ClimbStairs test = new ClimbStairs();
        test.climbStairs(6);
    }
}
