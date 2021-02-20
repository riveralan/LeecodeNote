public class SearchInsert {
    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (target < nums[left]) {
            return left;
        }
        if (target > nums[right]) {
            return right + 1;
        }
        int mid = left + (right - left) / 2;
        if (left < right - 1) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return search(nums, mid, right, target);
            } else {
                return search(nums, left, mid, target);
            }
        } else if (target > nums[left]) {
            return left + 1;
        } else {
            return right - 1;
        }
    }

    public static void main(String[] args) {
        SearchInsert test = new SearchInsert();
        int[] nums = {1};
        int i = test.searchInsert(nums, 1);
        System.out.println(i);
    }
}
