import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; (nums[i] <= 0) && i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> item = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(item);
                    right--;
                    left++;
                } else if (temp > 0) {
                    right--;
                } else {
                    left++;
                }
                while (left < right && left - 1 > i && nums[left] == nums[left - 1]) left++;
                while (left < right && right + 1 < nums.length - 1 && nums[right] == nums[right + 1]) right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        List<List<Integer>> lists = test.threeSum(new int[]{0,0,0});
        System.out.println(lists);
    }
}
