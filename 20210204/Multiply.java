public class Multiply {
    /**
     * 模拟手算
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n = num1.length(), m = num2.length();
        //最多大一位，给足空间
        int[] res = new int[n + m ];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int temp = a * b;
                temp += res[i + j + 1];
                res[i + j + 1] = temp % 10;

                res[i + j] += temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Multiply multiply =new Multiply();
        String multiply1 = multiply.multiply("123", "456");
        System.out.println(multiply1);
    }
}
