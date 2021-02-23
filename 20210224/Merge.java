public class Merge {
    /**
     * 后插法，谁大谁先走
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = nums1.length - 1;
        m--;
        n--;
        while (n>=0){
            while(m>=0&& nums1[m] > nums2[n]){
                int after = p1--,before = m--;
                int temp = nums1[after];
                nums1[after] = nums1[before];
                nums1[before] = temp;
            }
            int after = p1--,before = n--;
            nums1[after] = nums2[before];
        }
    }

    public static void main(String[] args) {
        Merge test = new Merge();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        test.merge(nums1,3,new int[]{2,5,6},3);
        System.out.println(nums1);
    }

}
