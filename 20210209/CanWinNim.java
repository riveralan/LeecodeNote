public class CanWinNim {
    /**
     * 1：你赢
     * 2：你赢
     * 3：你赢
     * 4：你输:1+3:false;2+2:false;3+1:false = false
     * 5：你赢；1+4
     * 6：你赢：2+4
     * 7：你赢：3+4
     * 8：你输：1+7。2+6，3+5
     * 9:1+8，你赢
     * 设置dp[i]为石头数为i时，先手者是否可以赢,dp[i]只与前面3个数字有关，循环利用容量为3的数组
     *
     * @param
     * @return
     */
    static class DP {
        boolean[] dp = {true, true, true};
        int firstIndex = 0;
        int current = 0;

        public boolean getDp(int index) {
            return dp[index];
        }

        public boolean getResult() {
            if (firstIndex == 0) {
                return dp[2];
            } else {
                return dp[firstIndex - 1];
            }
        }

        public void reset() {
            current = firstIndex;
        }

        public boolean next() {
            boolean result = dp[current];
            current++;
            if (current > 2) {
                current = 0;
            }
            return result;
        }

        public void update(boolean value) {
            dp[firstIndex] = value;
            firstIndex++;
            if (firstIndex > 2) {
                firstIndex = 0;
            }
        }
    }

    public boolean canWinNim(int n) {
        DP dp = new DP();
        if (n <= 3) {
            return dp.getDp(n - 1);
        }
        for (int i = 4; i <= n; i++) {
            //循环利用3位数组
            dp.reset();
            //前3位有一个是false，则这个数量的必胜，否则必输
            boolean temp = !dp.next() | !dp.next() | !dp.next();
            //更新dp
            dp.update(temp);
        }
        return dp.getResult();
    }

    public static void main(String[] args) {
        CanWinNim canWinNim = new CanWinNim();
        boolean b = canWinNim.canWinNim(6);
        System.out.println(b);
    }
}
