public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (right >= left) {
            if(nums[left]<nums[right]){//无旋转点
                return nums[left];
            }
            int mid = (left+right)>>1;
            if (nums[mid] > nums[mid + 1]) {//选中点刚好在旋转点的左边
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {//选中点刚好在旋转点的右边
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {//旋转点在左右区间
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMin test =new FindMin();
      int resutl =  test.findMin(new int[]{11,13,15,17});
      System.out.println(resutl);
    }
}
