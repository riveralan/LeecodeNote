import java.util.PriorityQueue;
import java.util.Queue;

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

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //建立小根堆
        Queue<ListNode> minHead = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHead.offer(node);
            }
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (!minHead.isEmpty()) {
            ListNode minNode = minHead.poll();
            cur.next = minNode;
            cur = minNode;
            if (minNode.next != null) {
                minHead.offer(minNode.next);
            }
        }
        return result.next;
    }
}
