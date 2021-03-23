package LeecodeNote.day41_20210321;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {
    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backTrack(digits, 0, new StringBuffer(), result);
        return result;
    }

    private void backTrack(String digits, int indexDigit, StringBuffer combination, List<String> result) {
        if (indexDigit == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(indexDigit);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backTrack(digits, indexDigit + 1, combination, result);
                combination.deleteCharAt(indexDigit);
            }
        }
    }
}
