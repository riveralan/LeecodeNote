/**
解题思路：明显可以用递归

sum ：从根节点到叶子节点的路径上的节点值相加的目标和递归。转为判断：左、右子树中能否找出和为 sum - root.val 的路径 
每遍历一个节点，sum 就减去当前节点值，当遍历到叶子节点时，已经没有子节点了，如果 sum == 当前叶子节点值，就是找到了从根节点到叶子节点的和为 sum 的路径
**/
class Solution {
    public boolean hasPathSum(TreeNode node, int sum) {
        if(node == null) {
            return false;
        }
        //达到叶节点
        if(node.left == null && node.right ==null){
            return node.val == sum ;
        }
        return hasPathSum(node.left,sum-node.val) || hasPathSum(node.right,sum-node.val);
    }
}