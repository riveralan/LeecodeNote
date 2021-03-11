import javax.swing.tree.TreeNode;


public class IsBalanced {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        int floor = countChildHeight(root);
        return floor != -1;
    }

    private int countChildHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = countChildHeight(node.left);
        if (leftHeight == -1) return leftHeight;
        int rightHeight = countChildHeight(node.right);
        if (rightHeight == -1) return rightHeight;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        IsBalanced tes = new IsBalanced();
        boolean result = tes.isBalanced(root);
        System.out.println(result);
    }
}
