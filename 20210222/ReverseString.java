public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0,j=len-1; i < len / 2; i++,j--) {
            swap(s,i,j);
        }
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        char[] s = {'h','e','l','l','o','1'};
        test.reverseString(s);
        System.out.println(s);
    }
}
