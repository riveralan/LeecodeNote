import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            //当遇到"]"时，开始找字母字符串
            if (s.charAt(i) == ']') {
                String ans = "";
                //只要不是"["就一直pop
                while (!st.peek().equals("[")) {
                    //注意拼接顺序，后出来的拼在前面
                    ans = st.pop() + ans;
                }
                //把 "[" 给扔了
                st.pop();
                //开始统计字母字符串前面的数字
                String res = "";
                //当栈不为空，且栈顶元素是数字
                while (!st.isEmpty() && (st.peek().charAt(0) >= '0' && st.peek().charAt(0) <= '9')) {
                    res = st.pop() + res;
                }
                //拆箱
                int count = Integer.parseInt(res);
                //答案字符串
                String retString = "";
                for (int j = 0;j < count; j++) {
                    retString += ans;
                }
                //放入栈中
                st.push(retString);
            }
            //如果不是 "]"
            else {
                //继续压入栈中
                String str = "" + s.charAt(i);
                st.push(str);
            }
        }
        //取出栈中字符串
        String ret = "";
        while(!st.isEmpty()) {
            ret = st.pop() + ret;
        }
        return ret;
    }
}