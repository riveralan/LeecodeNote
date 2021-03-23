package LeecodeNote.day42_20210323;

public class Solution_38 {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        for (int i = 1; i < n; i++) {
            char[] chars = result.toCharArray();
            int j = 0;
            int count = 1;
            StringBuilder sb = new StringBuilder();
            while (j < chars.length) {
                if (j + 1 <= chars.length - 1 && chars[j] == chars[j + 1]){
                    count++;
                }
                else {
                    sb.append(count).append(chars[j]);
                    count = 1;
                }
                j++;
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_38 test = new Solution_38();
        String result = test.countAndSay(4);
        System.out.println(result);
    }
}
