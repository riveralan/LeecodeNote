//一直到达底部时，逆转两个节点
class Solution {
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
}