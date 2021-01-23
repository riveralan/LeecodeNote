  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode point = l1;
        while(point != null){
            int val = point.val + l2.val + carry;
            if(val>9){
                carry = val/10;
                val = val%10;
            }
            current.val = val;


            l1 = l1.next;
            l2 = l2.next;
            if(l1==null&& l2!=null){
                point = l2;
            }
            if(l1!=null&& l2==null){
                point = l1;
            }
            point = point.next;
            if(point!=null){
                current.next = new ListNode();
                current = current.next;
            }
        }
        current.next = null;
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers= new AddTwoNumbers();
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode result = addTwoNumbers.addTwoNumbers(l1,l2);
        System.out.println(result);
    }
}
