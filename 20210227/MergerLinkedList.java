import java.util.LinkedList;

public class MergerLinkedList {
    static class Node {
        public int val = 0;
        public Node next = null;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 合并k 个已排序的链表并将其作为一个已排序的链表返回
     * 输入
     * [{1,2,3},{4,5,6,7}]
     * 返回值
     * {1,2,3,4,5,6,7}
     *
     * 解题思路
     * 小根堆+遍历
     *
     * O(log(n))
     * o(k)
     * @param input
     * @return
     */
    public Node mergerLinkedList(Node[] input) {

        return null;
    }
}
