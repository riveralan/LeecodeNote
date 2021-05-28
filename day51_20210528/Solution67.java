package LeecodeNote.day51_20210528;

public class Solution67 {
    public String addBinary(String a, String b) {
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;
        shorter = fillZero(shorter, longer.length() - shorter.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = longer.length() - 1; i >= 0; i--) {
            int l = longer.charAt(i) == '1' ? 1 : 0;
            int s = shorter.charAt(i) == '1' ? 1 : 0;
            int temp = l + s + carry;
            result.append(temp % 2);
            carry = temp / 2;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    private String fillZero(String source, int zeroCount) {
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < zeroCount; i++) {
            zero.append("0");
        }
        zero.append(source);
        return zero.toString();
    }
}
