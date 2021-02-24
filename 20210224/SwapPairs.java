import java.util.List;

public class SwapPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        swap(pre);
        return pre.next;
    }
    private void swap(ListNode pre) {
        if(pre.next==null){
            return;
        }
        ListNode left = pre.next;
        ListNode right = left.next;
        if(right==null){
            return;
        }
        ListNode next = right.next;
        pre.next = right;
        right.next = left;
        left.next = next;
        swap(left);
    }

    public static void main(String[] args) {
        SwapPairs test = new SwapPairs();
        ListNode list = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode result =  test.swapPairs(list);
        System.out.println(result);
    }
}
