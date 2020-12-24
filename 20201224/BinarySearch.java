public class BinarySearch {
    int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left<=right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        FastSort fastSort =new FastSort();
        int[] arr = {2,3,5,7,1,4,6,15,5,2,7,9,10,15,9,17,12};
        fastSort.sort(arr,0,arr.length-1);
        for(int index =0;index<arr.length;index++){
            System.out.print(index+":"+arr[index]+",");
        }
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(arr,6);
        System.out.println("----");
        System.out.println(index);
    }
}
