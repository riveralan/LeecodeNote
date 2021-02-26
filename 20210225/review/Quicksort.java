public class Quicksort {
    public void quicksort(int[] n) {
        sort(n, 0, n.length - 1);
    }

    private void sort(int[] n, int left, int right) {
        if(left<right){
            int p =  patition(n, left,right);
            sort(n,left,p-1);
            sort(n,p+1,right);
        }

    }

    /**
     * 一趟排序
     *
     * @param n
     * @param left
     * @param right
     */
    private int patition(int[] n, int left, int right) {
        //基准
        int pviot = n[left];
        int i = left  , j = right;
        while(i<j){
            while (i < j && n[j] >= pviot) j--;
            while (i < j && n[i] <= pviot) i++;
            swap(n,i,j);
        }
        swap(n,left,i);
        return i;
    }

    private void swap(int[] n, int left, int right){
        int temp = n[left];
        n[left] = n[right];
        n[right] = temp;
    }

    public static void main(String[] args) {
        Quicksort test = new Quicksort();
        int n[] = { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1 };
        test.quicksort(n);
        for (int m : n) {
            System.out.print(m + " ");
        }
    }
}
