import java.util.List;

public class MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //特例
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHeadNode = new ListNode();
        dummyHeadNode.next = l1.val > l2.val ? l2 : l1;
        ListNode pre = dummyHeadNode;
        ListNode curr = dummyHeadNode.next;
        ListNode bigger = l1.val > l2.val ? l1 : l2;
        while (bigger != null && curr.next != null) {
            if (bigger.val >= curr.val && bigger.val <= curr.next.val) {
                ListNode next = curr.next, biggerNext = bigger.next;
                bigger.next = next;
                curr.next = bigger;
                bigger = biggerNext;
            }
            curr = curr.next;
            pre = pre.next;
        }
        if (bigger != null) {
            curr.next = bigger;
        }
        return dummyHeadNode.next;
    }

    public static void main(String[] args) {
        MergeTwoLists test = new MergeTwoLists();
        ListNode result = test.mergeTwoLists(new ListNode(5), new ListNode(1, new ListNode(2, new ListNode(4))));
        System.out.println(result);
    }

    /**
     * 迭代
     **/
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
