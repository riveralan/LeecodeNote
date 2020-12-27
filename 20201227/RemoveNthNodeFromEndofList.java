/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
解题思路：
设置三个指针，preDeleteNode、deleteNode，currentNode，同时指向head
curent先往前移动n-1位后，所有指针同步移动，直到currentNode遇到尾结点，把preDeleteNode指向deleteNode.next即可删除。
**/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode deleteNode = head;
        ListNode deletePreNode = preHead;
        ListNode currentNode = head;
        int k = n;
        while(k>1 && currentNode.next!=null){
            currentNode = currentNode.next;
            k--;
        }
        while(currentNode.next!=null){
            currentNode = currentNode.next;
            deleteNode = deleteNode.next;
            deletePreNode = deletePreNode.next;
        }
        deletePreNode.next = deleteNode.next;
        return preHead.next;
    }
}