class Trap {
    /**
     * 双指针
     * 两边各一个指针，向中间靠拢，要求每次落点都要大于等于1
     * 取最短指针作为扣减值，当值每扣成负数时，取反就是最短指针能够容纳的雨水，为了重复计算，取反后置位零
     * 重复至两个指针会面
     *
     * @param height
     * @return
     */
    public int  trap(int[] height) {
        int left = 0,right = height.length-1,res = 0;
        while(left < right &&left+1!=right){
            if(height[left]< 1){
                left++;
                continue;
            }
            if(height[right]< 1){
                right--;
                continue;
            }
            int min = Math.min(height[left], height[right]);
            for(int i = left;i<=right;i++){
                height[i] -= min;
                if(height[i] <= -1){
                    res = res - height[i];
                    height[i] = 0;
                }
            }
        }
        return res;
    }
}