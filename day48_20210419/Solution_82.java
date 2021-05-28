package LeecodeNote.day48_20210419;

public class Solution_82 {
    public static class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (cur.val != next.val) {
                next = next.next;
                cur = cur.next;
                pre = pre.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
                if (next != null) {
                    cur = next;
                    next = next.next;
                }
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Solution_82 solution_82 = new Solution_82();
        //1,2,3,3,4,4,5
        ListNode listNode = solution_82.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
        System.out.println(listNode);
    }
}
