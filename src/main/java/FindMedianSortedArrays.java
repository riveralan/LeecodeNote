public class FindMedianSortedArrays {

    /**
     * 解题思路：
     * 空间复杂度为O(log(m+n))可以试试从二分查找法入手
     * 找中位数可以变成找第k小数【m+n为奇数只需要找(m+n+1)即可，偶数需要找(m+n+1)、(m+n+2)*0.5】
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;

        int[] shortNums = nums1.length < nums2.length ? nums1 : nums2;
        int[] longNums = nums1.length > nums2.length ? nums1 : nums2;
        int shortLength = shortNums.length;
        int longLength = longNums.length;
        if (totalLength % 2 == 0) {//偶数
            return (findKth(shortNums, longNums, 0, 0, shortLength + longLength + 1)
                    + findKth(shortNums, longNums, 0, 0, shortLength + longLength + 1)) * 0.5;

        } else {//奇数
            return findKth(shortNums, longNums, 0, 0, shortLength + longLength + 1);
        }
    }

    private int findKth(int[] shortNums, int[] longNums, int i, int j, int k) {
        int index = k / 2 - 1;
        if (index > shortNums.length - 1) {
            return longNums[j + k];
        }
        if (shortNums[index] > longNums[index]) {
            return findKth(shortNums, longNums, i, index, k / 2);
        } else {
            return findKth(shortNums, longNums, index, j, k / 2);
        }
    }
}
