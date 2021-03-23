package LeecodeNote.day40_20210320;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = nums.length - 2, right = left + 1;
        //找左边小数
        while (left >= 0 && nums[left] >= nums[left + 1])  left--;
        //找不到小数，直接逆转
        if (left < 0) {
            asc(nums, 0, nums.length - 1);
        }else {//找到-》先交换后把后面的数升序
            //找右边最接近左边小数的大数
            while (left < right && nums[left] >= nums[right]) right--;
            swap(nums, left, right);
            //左边指针在倒数第三位后，没有升序的必要
            if (nums.length  - 3 >= left) {
                asc(nums, left + 1, nums.length - 1);
            }
        }

    }

    private void asc(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int left, int right) {
        if(left!=right){
            nums[right] = nums[left] + nums[right];
            nums[left] = nums[right] - nums[left];
            nums[right] = nums[right] - nums[left];
        }
    }

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] result = new int[]{5,1,1};
        test.nextPermutation(result);
        System.out.println(result);
    }
}
