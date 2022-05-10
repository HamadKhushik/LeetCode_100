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



/* Iterative Solution
        
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
*/

// Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head) {     
        return reverse(head, null);
    }
    
    public ListNode reverse(ListNode head, ListNode newHead){
        if (head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        
        return reverse(next, head);
    }
}