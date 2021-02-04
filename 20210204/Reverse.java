public class Reverse {
    public int reverse(int x) {
        int negativeFlag = x < 0 ? -1 : 1;
        x = negativeFlag * x;
        int result = 0;
        while (x != 0 && x % 10 >= 0) {
            int temp = x % 10;
            //溢出前判断一下
            if (result > (0x7fffffff - temp) / 10) {
                result = 0;
                break;
            }
            result = result * 10 + temp;
            x = x / 10;
        }
        return negativeFlag * result;
    }

    public int reverse1(int x) {
        boolean negativeFlag = false;
        if (x < 0) {
            negativeFlag = true;
            x = -x;
        }
        int result = 0;
        int max = 0x7fffffff;

        while (x != 0 && x % 10 >= 0) {
            int temp = x % 10;
            if (result > (max - temp) / 10) {
                result = 0;
                break;
            }
            result = result * 10 + temp;
            x = x / 10;
        }
        return negativeFlag ? -result : result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int result = reverse.reverse(123);
        System.out.println(result);
    }
}
