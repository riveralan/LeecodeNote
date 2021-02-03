import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        public Node prev, next;
        public int key, value;
        public int size = 0;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }

    private final int capacity;
    private final Node tail = new Node();
    private final Node head = new Node();
    private final Map<Integer, Node> map = new HashMap<>();

    /**
     * 解题思路：
     * （1）可以用栈，每次操作弹出，找到元素后，依次压入再把元素压入。但是此操作时间复杂度与空间复杂度都较高，故不采用
     * （2）用双向链表，头节点插入，每次get后，把节点移动到头节点，如果容量超过，则删除尾节点
     **/
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //移动节点到头节点
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else{
            //溢出先删除
            if (head.size >= capacity) {
                Node temp = tail.prev;
                tail.prev = temp.prev;
                temp.prev.next = tail;
                map.remove(temp.key);
                head.size--;
            }
            //添加
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            head.size++;
        }

    }
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(Node addNode) {
        head.next.prev = addNode;
        addNode.prev = head;
        addNode.next = head.next;
        head.next = addNode;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        System.out.println(obj.get(2));
        obj.put(2, 6);
        System.out.println(obj.get(1));
        obj.put(1, 5);
        obj.put(1, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }
}
