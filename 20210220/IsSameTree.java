
class TreeNode {
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

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else if (p != q) {
                return false;
            }
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        IsSameTree test = new IsSameTree();
        TreeNode p = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode q = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        boolean sameTree = test.isSameTree(p, q);

        System.out.println(sameTree);
    }
}
