package LeecodeNote.day50_20210517;

public class Solution_415 {
    public String addStrings(String num1, String num2) {
        String longest = num1.length() > num2.length() ? num1 : num2;
        String shortest = num1.length() > num2.length() ? num2 : num1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = longest.length() - 1;
        int j = shortest.length() - 1;
        while (i >= 0) {
            int add1 = getInteger(longest, i--);
            int add2;
            if (j < 0) {
                add2 = 0;
            } else {
                add2 = getInteger(shortest, j--);
            }
            int sum = carry + add1 + add2;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            result.insert(0, (char) (sum + '0'));

        }
        if (carry != 0) {
            result.insert(0, (char) (carry + '0'));
        }
        return result.toString();
    }

    private int getInteger(String str, int index) {
        return str.charAt(index) - '0';
    }

    public static void main(String[] args) {
        Solution_415 solution_415 = new Solution_415();
        String result = solution_415.addStrings("456", "77");
        System.out.println(result);
    }
}
