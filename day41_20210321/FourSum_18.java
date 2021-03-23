package LeecodeNote.day41_20210321;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //去重i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //去重j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        List<Integer> items = new ArrayList<>();
                        items.add(nums[i]);
                        items.add(nums[j]);
                        items.add(nums[left]);
                        items.add(nums[right]);
                        result.add(items);
                        //去重left和right
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum_18 test = new FourSum_18();
        List<List<Integer>> result =  test.fourSum(new int[]{1,0,-1,0,-2,2},0);
    }

}
