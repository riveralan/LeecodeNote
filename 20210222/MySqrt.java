public class MySqrt {
    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left = 1, right = x;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid >= x) {
                right = mid;
                left = mid + 1;
            }
        }
        Long result = (left * left > x) ? left - 1 : left;
        return  Integer.parseInt(result.toString()) ;
    }

    public static void main(String[] args) {
        MySqrt test = new MySqrt();
        int v = test.mySqrt(2147395599);
        System.out.println(v);
    }
}
