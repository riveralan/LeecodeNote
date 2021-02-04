public class IsPalindrome {
    /**
     反着读，然后比较
     **/
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reverse = reverse(x);
        return x == reverse;
    }

    private int reverse(int x) {
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
        return result;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome(121);
        System.out.println(palindrome);
    }
}
