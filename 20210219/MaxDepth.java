

public class MaxDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            return deep;
        }
        int leftDeep = 0, rightDeep = 0;
        if (root.left != null) {
            leftDeep = maxDepth(root.left, deep + 1);
        }
        if (root.right != null) {
            rightDeep = maxDepth(root.right, deep + 1);
        }
        return Math.max(leftDeep, rightDeep);
    }

    public static void main(String[] args) {
        MaxDepth test = new MaxDepth();
        TreeNode p = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        int depth = test.maxDepth(p);

        System.out.println(depth);
    }
}
