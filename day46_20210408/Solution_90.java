package LeecodeNote.day46_20210408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            List<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);
            backTrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_90 test = new Solution_90();
        List<List<Integer>> result = test.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(result);
    }
}
