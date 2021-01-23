public class MaxArea {
    /**
     * 解题思路：双指针
     * 若对于数组a，来说，长度若为8，我们可以想象固定这个8，这个面积的最大值取决于短板；
     * 若缩小一个长度为7，那么移动长板后，短板还是不变，面积只会变小，如果移动短板，下一个是多少不确定，但是不会超过目前长板，
     * 如此类推，应该每次收缩短板，保存最大面积，直到两板相遇
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0,j=height.length,maxArea = 0;
        while(i!=j){
            maxArea = height[i] >height[j]?
                    Math.max(maxArea,(j-i)* height[j--]):
                    Math.max(maxArea,(j-i)* height[i--]);
        }
        return maxArea;
    }
}
