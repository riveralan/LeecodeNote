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

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            int i = 0;
            while(i++<k){
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            //保存尾指针
            ListNode next = tail.next;
            //逆转
            reverse(head, tail,pre,next);
            pre = head;
            head = next;
        }

        return hair.next;
    }

    public void reverse(ListNode head, ListNode tail,ListNode pre,ListNode next) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nextTemp = p.next;
            p.next = prev;
            prev = p;
            p = nextTemp;
        }
        pre.next = tail;
        head.next = next;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode test = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = reverseKGroup.reverseKGroup(test, 2);
        System.out.println(listNode);
    }
}
