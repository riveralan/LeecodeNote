import java.util.Arrays;

public class LengthOfLIS {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i =0 ;i<nums.length;i++){
            for(int j = i;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    /**
     * 贪心+二分
     * 时：o(nlogn);空：O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int [] cell = new int[nums.length];
        cell[0] = nums[0];
        int left =0,right = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i]>cell[right]){
                cell[++right] = nums[i];
            }else{//二分插入
                int l = 0, r = right, pos = -1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (cell[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                cell[pos+1] = nums[i];
            }
        }
        return right+1;
    }

    public static void main(String[] args) {
        LengthOfLIS test = new LengthOfLIS();
        int result = test.lengthOfLIS1(new int[]{4,10,4,3,8,9});
        System.out.println(result);
    }
}
