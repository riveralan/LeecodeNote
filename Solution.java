package LeecodeNote;


import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        Deque<String> stack = new LinkedList();
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int start = i;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    i++;
                }
                stack.push(s.substring(start, i));
                i--;
            } else if ("]".equals(String.valueOf(c))) {
                if (stack.isEmpty()) {
                    continue;
                }
                String temp = "";
                while (!stack.isEmpty()) {
                    String alpha = stack.poll();
                    alpha = alpha + temp;
                    temp = alpha;
                    Integer digit = Integer.valueOf(stack.poll());
                    for (int j = 1; j < digit; j++) {
                        temp += alpha;
                    }
                }
                result.append(temp);
            } else if (isAlpha(chars[i])) {
                int start = i;
                while (i < chars.length && isAlpha(chars[i])) {
                    i++;
                }
                if (!stack.isEmpty()) {
                    stack.push(s.substring(start, i));
                }else {
                    result.append(s, start, i);
                }
                i--;
            }
        }
        return result.toString();
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String i = solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(i);
    }

}