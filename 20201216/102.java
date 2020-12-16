/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 利用队列遍历
     * 1、初始化，新建两个队列A、B，把根节点塞入队列A中
     * 2、选取一个元素不为空的队列(假设是A)，从队列中弹出元素，把元素值塞入子list中，同时读取元素左右子元素塞入队列B中，直到队列A为空,子list塞进总list中
     * 3、选取一个元素不为空的队列(假设是B)，从队列中弹出元素，把元素值塞入子list中，同时读取元素左右子元素塞入队列A中，直到队列B为空,子list塞进总list中
     * 4、循环二三步，直到AB同时为空
     * 5、返回总list
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
         if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> A = new LinkedList<>();
        Queue<TreeNode> B = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        A.add(root);
        for(;A.size()!=0 || B.size()!=0;){
            List<Integer> item = new ArrayList<>();
            Queue<TreeNode> read = A.size()!=0? A : B;
            Queue<TreeNode> save = A.size()!=0? B : A;
            TreeNode itemNode;
            while((itemNode = read.poll())!=null){
                item.add(itemNode.val);
                if(itemNode.left!=null) save.add(itemNode.left);
                if(itemNode.right!=null) save.add(itemNode.right);
            }
            result.add(item);
        }
        return result;
    }
}