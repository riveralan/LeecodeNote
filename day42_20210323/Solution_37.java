package LeecodeNote.day42_20210323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_37 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int begin, int target, List<Integer> path, List<List<Integer>> result) {
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            int rest = target - candidates[i];
            if (rest == 0) {
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            } else if (rest > 0) {
                dfs(candidates, i, rest, path, result);
                path.remove(path.size() - 1);
            } else {
                path.remove(path.size() - 1);
                //剪枝，已排序，这个如果已经小于0，那么后面的必定小于零
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution_37 test = new Solution_37();
        List<List<Integer>> result = test.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(result);
    }

}