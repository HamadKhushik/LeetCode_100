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

/*
Iterative Solution
    public ListNode reverseList(ListNode head) {
        ListNode newHead;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

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

*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }   

}