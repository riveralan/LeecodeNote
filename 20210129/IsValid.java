import java.util.Stack;

public class IsValid {
    /**
     * 解题思路：栈，左括号入，遇到右括号出，不匹配就是false，一直匹配到栈空以及字符串完成则为true
     **/
    public boolean isValid(String s) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));

            if ("({[".contains(str)) {
                stack.push(str);
            } else {
                String pop;
                if(!stack.empty()){
                    pop = stack.pop();
                }else{
                    return false;
                }
                if (("(".equals(pop) && ")".equals(str))||("[".equals(pop) && "]".equals(str))||("{".equals(pop) && "}".equals(str))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        isValid.isValid("()");
    }
}