class Solution {
    /**
    解题思路：双指针法
    1、设置两个指针，i指针指向第一个奇数索引，j指针指向第一个偶数索引
    2、若i指向一个偶数，则从j中找可交换的值（j指向一个奇数），每次+2
    **/
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) j += 2;
                swap(A, i, j);
            }
        }   
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}