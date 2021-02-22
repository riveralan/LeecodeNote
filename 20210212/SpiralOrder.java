import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    /**
     * 模拟法
     * 从外向内分为若干个闭合矩形，若矩形长宽有一个为0，遍历结束，无序记录遍历过的数字
     *
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rectLength = matrix[0].length, rectWidth = matrix.length;
        //层数
        int count = 0 ,maxCount = (Math.min(rectLength,rectWidth)-1)/2;
        while (maxCount>=count) {
            int col = count, row = count;
            for(;col< rectLength - count;col++){
                result.add(matrix[row][col]);
            }
            if(rectWidth-count*2 <=1) break;
            for(row = count + 1,col--;row<rectWidth - count;row++){
                result.add(matrix[row][col]);
            }
            if(rectLength-count*2 <=1) break;
            for(col = rectLength - count - 2,row--; col > count-1;col --){
                result.add(matrix[row][col]);
            }
            for (row = rectWidth - count - 2,col++; row > count;row --){
                result.add(matrix[row][col]);
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder test = new SpiralOrder();
        /**
         * 2  3  8
         * 4  0  -1
         */
        List<Integer> result = test.spiralOrder(new int[][]{{2,3,8},{4,0,-1}});
        System.out.println(result);
    }
}
