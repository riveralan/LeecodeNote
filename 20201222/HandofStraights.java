class Solution {
    /**
    解题思路
    1、不能被w整除，排除
    2、==1排除
    3、排序并组合
    **/
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W!=0){
            return false;
        }
        if (W ==1) {
            return true;
        }
        Arrays.sort(hand);
        int num = 0;
        for(int i = 0 ;i < hand.length;i++){
            if(hand[i]==-1){
                continue;
            }
            int pre = hand[i];
            hand[i]= -1;
             num = 1;
            for(int j=i;j<hand.length;j++){
                if(hand[j]==-1){
                    continue;
                }
                if(hand[j]==pre){
                    continue;
                }
                if(hand[j]-1 == pre){
                    num++;
                    pre = hand[j];
                    hand[j] = -1;
                }else{
                    return false;
                }
                if(num == W){
                    break;
                }
            }
        }
        if(num==W){
            return true;
        }else{
            return false;
        }
    }
}