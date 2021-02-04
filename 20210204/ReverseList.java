
class ListNode {
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

public class ReverseList {
    private ListNode reverse;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        reverse(head, null);
        return reverse;
    }

    private void reverse(ListNode head, ListNode pre) {
        if (head.next != null) {
            reverse(head.next, head);
        } else {
            reverse = head;
        }
        head.next = pre;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.reverseList(new ListNode(1));
        System.out.println(listNode);
    }

}
