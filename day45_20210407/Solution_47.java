package LeecodeNote.day45_20210407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {
    private int[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void permuteUnique(int[] nums, int floor, List<Integer> path, List<List<Integer>> result) {
        if (floor == nums.length) {
            List<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1] == 0)) {
                continue;
            }
            path.add(nums[i]);
            vis[i] = 1;
            permuteUnique(nums, floor + 1, path, result);
            vis[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_47 solution_47 = new Solution_47();
        List<List<Integer>> result = solution_47.permuteUnique(new int[]{1, 1, 2});
        System.out.println(result);
    }
}
