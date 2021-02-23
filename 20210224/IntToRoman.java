/**
 * 解题思路，贪心算法
 */
public class IntToRoman {
    private int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] sign = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length && num > 0; i++) {
            while (nums[i] <= num) {
                num -= nums[i];
                result.append(sign[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntToRoman test = new IntToRoman();
        String result =  test.intToRoman(3);
        System.out.println(result);
    }
}
