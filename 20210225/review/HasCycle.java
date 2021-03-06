public class HasCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
