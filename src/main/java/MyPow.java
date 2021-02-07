public class MyPow {
    public double myPow(double x, int n) {
        if(x==1){
            return x;
        }
        return n > 0 ?  pow(x, n) : 1 /  pow(x, -n);
    }

    public double pow(double x, int n) {
        if(n==0){
            return 1;
        }
        double v = pow(x, n / 2);
        return n % 2 == 0 ? v*v:v * v * x;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2.10000, 3);
        System.out.println(v);
    }
}
