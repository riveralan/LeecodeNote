package LeecodeNote.solution;


/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * Related Topics 递归 链表 👍 629 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

public class FanZhuanLianBiaoLcof {
    private ListNode revertNode = null;
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null)  return head;
        dfs(head,head.next);
        return revertNode;
    }

    private void dfs(ListNode parent,ListNode current){
        if(current.next !=null) dfs(current,current.next);
        if(revertNode==null && current.next == null) revertNode  = current;
        current.next = parent;
        parent.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
