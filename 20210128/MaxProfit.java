public class MaxProfit {
    /**
     解题思路：
     记录当前值与前面最小值的最大差值
     **/
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxValue = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxValue = Math.max(prices[i] - min, maxValue);
        }
        return maxValue;
    }
}
