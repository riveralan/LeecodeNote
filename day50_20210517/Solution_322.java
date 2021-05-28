package LeecodeNote.day50_20210517;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int coinsLen = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minCount = amount + 1;
            for (int j = coinsLen - 1; j >= 0; j--) {
                if (coins[j] == i) {
                    minCount = 1;
                    break;
                } else if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
                    minCount = Math.min(dp[i - coins[j]] + 1, minCount);
                }
            }
            if (minCount == amount + 1) {
                dp[i] = -1;
            } else {
                dp[i] = minCount;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution_322 solution_322 = new Solution_322();
        int count = solution_322.coinChange(new int[]{1}, 1);
        System.out.println(count);
    }
}
