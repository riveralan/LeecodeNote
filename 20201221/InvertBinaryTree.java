class Solution {
    /**
    解题思路：递归
    **/
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        //交换节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}