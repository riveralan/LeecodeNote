import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeSolution {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * 使用队列辅助
     *
     * @param root
     * @return
     */
    public List<List<Integer>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> readQueue = new LinkedBlockingQueue<>();
        Queue<TreeNode> writeQueue = new LinkedBlockingQueue<>();
        readQueue.add(root);
        while ((readQueue = readQueue.isEmpty() ? writeQueue : readQueue) != null) {
            writeQueue.clear();
            List<Integer> temp = new ArrayList<>();
            while (!readQueue.isEmpty()) {
                TreeNode treeNode = readQueue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    writeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    writeQueue.add(treeNode.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

}
