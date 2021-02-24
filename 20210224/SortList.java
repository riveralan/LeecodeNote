public class SortList {

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

    public ListNode sortList(ListNode head) {
        //为空直接返回
        if (head == null) {
            return head;
        }
        int length = 0;
        //计算总长度
        ListNode countNode = head;
        while (countNode != null) {
            length++;
            countNode = countNode.next;
        }

        //前置节点
        ListNode dummyPreHead = new ListNode(0, head);
        //迭代排序合并，直到长度等于总长
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyPreHead, curr = dummyPreHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = mergeSort(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyPreHead.next;
    }


    /**
     * 合并排序
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        //使用temp重新排序，并组装成一个新的链表，使用之前的元素
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        //假如两个链表长度不一样，会出现一个元素遗落的情况
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode result = test.sortList(listNode);
        System.out.println(result);
    }
}
