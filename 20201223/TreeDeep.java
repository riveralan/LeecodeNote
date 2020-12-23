/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 解题思路：递归
 1、递归左右节点，到最后一层和maxDeep比对，找出最大
 2、递归完所有树后，即可获得最大的层数
 **/
class Solution {
    int maxDeep;
    public int maxDepth(TreeNode root) {
        getDeep(root,1);
        return maxDeep;
    }
    public void getDeep(TreeNode root,int deep){
        if(root!=null){
            getDeep(root.left,deep+1);
            getDeep(root.right,deep+1);
        }
        maxDeep =  Math.max(maxDeep,deep-1);
    }
}