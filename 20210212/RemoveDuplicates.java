public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int current = 0, next = 0, n = nums.length;
        while (next < n) {
            if (nums[current] != nums[next]) {
                nums[current + 1] = nums[next];
                current++;
            }
            next++;
        }
        return current + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length =  test.removeDuplicates(nums);
        System.out.println(length);
    }
}
