import java.util.HashMap;

public class TwoNumsSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 哈希法
     * @param nums
     * @param target
     * @return
     */

    public int[] findSum(int [] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int curr = nums[i];
            int other = target -  curr;
            if(map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(curr,i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoNumsSum test =  new TwoNumsSum();
        int [] result = test.findSum(new int[]{2, 7, 11, 15},9);
        System.out.println(result);
    }
}
