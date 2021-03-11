public class Jump02 {
    public int jump(int[] nums) {
        if (nums.length > 0 && nums[0] == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0; i--) {
            int minStep = Integer.MAX_VALUE;
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > end) {
                    break;
                }
                if(dp[i + j] == Integer.MAX_VALUE){
                        continue;
                }
                minStep =  Math.min(minStep, dp[i + j] + 1);
            }
            dp[i] = minStep;
        }
        return dp[0];
    }
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump02 test = new Jump02();
        int result = test.jump2(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        System.out.println(result);
    }
}
