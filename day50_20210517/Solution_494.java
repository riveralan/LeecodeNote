package LeecodeNote.day50_20210517;

public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        int leave ;
        leave = -target - nums[index];
        int a = findTargetSumWays(nums, leave, index+1);
        leave = -target + nums[index];
        int b = findTargetSumWays(nums, leave, index+1);
        return a + b;
    }

    public static void main(String[] args) {
        Solution_494 solution_494 = new Solution_494();
        int result = solution_494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(result);
    }
}
