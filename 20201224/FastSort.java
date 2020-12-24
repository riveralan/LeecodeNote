public class FastSort {
    /**
     * 解题思路
     * 1、选择start作为基点，设置left,right指针指向start，end；
     * 2、left指针递增，直到发现比基点大的
     * 3、right指针递减，直到发现比基点小的
     * 4、如果left,right指针的值相等且left<right,left++
     * 5、如果不是，则交换两个值
     * 6、直到left>=right,循环结束
     * 7、剩下两个分区递归排序
     * @param arr
     * @param start
     * @param end
     */
    public void sort(int arr[],int start,int end){
        int pivot = arr[start];
        int left  = start;
        int right = end;
        while(left<right){
            while((left<right)&&arr[left]<pivot) left++;
            while((left<right)&&arr[right]>pivot)
                right--;
            if(arr[left]==arr[right]&&left<right){
                left++;
            }
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if(start<left-1) sort(arr,start,left-1);
        if(end>right+1) sort(arr,right+1,end);
    }

    public static void main(String args[]){
        FastSort fastSort =new FastSort();
        int[] arr = {2,3,5,7,1,4,6,15,5,2,7,9,10,15,9,17,12};
        fastSort.sort(arr,0,arr.length-1);
        System.out.println(arr);
    }
}
