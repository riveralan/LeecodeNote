package LeecodeNote.day45_20210407;

import java.util.HashMap;
import java.util.Map;

public class Solution_13 {
    private final Map<String, Integer> charMap = new HashMap<>();

    public int romanToInt(String s) {

        charMap.put("I", 1);
        charMap.put("IV", 4);
        charMap.put("V", 5);
        charMap.put("IX", 9);
        charMap.put("X", 10);
        charMap.put("XL", 40);
        charMap.put("L", 50);
        charMap.put("XC", 90);
        charMap.put("C", 100);
        charMap.put("CD", 400);
        charMap.put("D", 500);
        charMap.put("CM", 900);
        charMap.put("M", 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I' || chars[i] == 'X' || chars[i] == 'C') {
                Integer dualInteger = getDualInteger(chars, i);
                if (dualInteger != null) {
                    i++;
                    result += dualInteger;
                    continue;
                }
            }
            result += charMap.get(String.valueOf(chars[i]));
        }
        return result;

    }

    private Integer getDualInteger(char[] chars, int i) {
        if (i + 1 == chars.length) {
            return null;
        }
        return charMap.get(String.valueOf(chars[i]) + chars[i + 1]);
    }

    public static void main(String[] args) {
        Solution_13 test = new Solution_13();
        int result = test.romanToInt("III");
        System.out.println(result);
    }
}
