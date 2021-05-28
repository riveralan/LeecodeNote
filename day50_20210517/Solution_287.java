package LeecodeNote.day50_20210517;

public class Solution_287 {
    public int findDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    private int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return right;
        }
        int key = nums[left];
        int start = left + 1;
        int end = right;
        while (start <= end) {
            if (nums[start] <= key) {
                start++;
            } else {
                swap(nums, start, end);
                end--;
            }
        }
        swap(nums, left, end);
        quickSort(nums, left, end - 1);
        quickSort(nums, end + 1, right);
        return end;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution_287 solution = new Solution_287();
        int result = solution.findDuplicate(new int[]{1,1,2});
        System.out.println(result);
    }
}
