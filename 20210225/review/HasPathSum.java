import javax.swing.tree.TreeNode;

public class HasPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode node, int sum) {
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            return node.val == sum;
        }
        return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
    }

}
