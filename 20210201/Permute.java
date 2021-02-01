import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     回溯算法
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, nums, 0);
        return results;
    }


    private void backtrack(List<List<Integer>> results, int[] nums, int floor) {
        if (nums.length == floor) {
            results.add(output(nums));
            return;
        }

        for (int i = floor; i < nums.length; i++) {
            swap(nums,floor,i);
            backtrack(results, nums, floor + 1);
            swap(nums,floor,i);
        }
    }

    private List<Integer>  output(int[] nums){
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }

    private void swap(int[] nums,int floor,int i){
        int tmp = nums[floor];
        nums[floor] = nums[i];
        nums[i] = tmp;
    }
}
