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
        if (totalLength % 2 == 0) {//偶数
            return (findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2)
                    + findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 2) / 2)) * 0.5;
        } else {//奇数
            return findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2);
        }
    }

    private int findKth(int[] shortNums, int shortStart, int[] longNums, int longStart, int k) {
        int shortLength = shortNums.length - shortStart;
        int longLength = longNums.length - longStart;

        //通过计算，如果短的比长的长，那么转换一下
        if (shortLength > longLength) return findKth(longNums, longStart, shortNums, shortStart, k);
        //如果短的没有长度了，直接把长的往后推k位
        if (shortLength == 0) return longNums[longStart + k - 1];
        //k==1，直接选一个最小的
        if (k == 1) return Math.min(shortNums[shortStart], longNums[longStart]);//

        //需要移动的索引位
        int shortNextMoveIndex = shortStart + Math.min(shortLength, k / 2) - 1;
        int longNextMoveIndex = longStart + Math.min(longLength, k / 2) - 1;

        if (shortNums[shortNextMoveIndex] > longNums[longNextMoveIndex]) {
            return findKth(shortNums, shortStart, longNums, longNextMoveIndex + 1, k - (longNextMoveIndex - longStart + 1));
        } else {
            return findKth(shortNums, shortNextMoveIndex + 1, longNums, longStart, k - (shortNextMoveIndex - shortStart + 1));
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        double medianSortedArrays = test.findMedianSortedArrays(nums1, nums2);
        // double medianSortedArrays = test.findMedianSortedArrays1(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
