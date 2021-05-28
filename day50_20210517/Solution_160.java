package LeecodeNote.day50_20210517;

public class Solution_160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;
        ListNode cur = headA;
        while (cur.next != null) {
            aLen++;
        }
        cur = headB;
        while (cur.next != null) {
            bLen++;
        }
        ListNode longest = aLen > bLen ? headA : headB;
        ListNode shortest = aLen > bLen ? headB : headA;
        int diffNum = Math.abs(aLen - bLen);
        while (diffNum-->0){
            longest = longest.next;
        }
        ListNode result =null;

        while(longest.val!=shortest.val){
            longest = longest.next;
            shortest = shortest.next;
        }
        result = longest;
    }
}
