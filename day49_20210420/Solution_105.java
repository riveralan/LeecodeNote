package LeecodeNote.day49_20210420;

import java.util.Arrays;

public class Solution_105 {
    static public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //前序遍历首个绝对是根节点
        TreeNode tree = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            //根据前序遍历找到中序遍历根节点位置
            if (preorder[0] == inorder[i]) {
                //遍历左树
                tree.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                //遍历右树
                tree.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return tree;
    }


}
