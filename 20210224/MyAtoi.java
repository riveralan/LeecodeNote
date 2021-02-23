import java.util.HashMap;
import java.util.Map;

public class MyAtoi {
    private Map<Integer, Integer[]> table = new HashMap<Integer, Integer[]>(){{
        //状态机状态1开始，2符号，3数字，4结束
        //数字:0，+/-:1,空格：2，其他：3
        //状态机开始
        put(1, new Integer[]{3, 2, 1, 4});
        //状态机符号
        put(2, new Integer[]{3, 4, 4, 4});
        //状态机数字
        put(3, new Integer[]{3, 4, 4, 4});
        //状态机结束
        put(4, new Integer[]{4, 4, 4, 4});
    }};
    private long result = 0;
    private int sign = 1;
    private int status = 1;


    public int myAtoi(String s) {
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            add(s.charAt(i));
        }
        return (int) (sign * result);
    }

    private void add(char c) {
        status = table.get(status)[getCol(c)];
        //当前处于数字状态
        if (status == 3) {
            result = result * 10 + c - '0';
            result = sign == 1 ? Math.min(result, (long) Integer.MAX_VALUE) : Math.min(result, -(long) Integer.MIN_VALUE);
        }
        if(status == 2){
            sign = c == '+' ? 1 : -1;
        }
    }

    private int getCol(char c) {
        if (Character.isDigit(c)) {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == ' ') {
            return 2;
        }
        return 3;
    }

    public static void main(String[] args) {
        MyAtoi test = new MyAtoi();
        int result =  test.myAtoi("-91283472332");
        System.out.println(result);

    }
}
