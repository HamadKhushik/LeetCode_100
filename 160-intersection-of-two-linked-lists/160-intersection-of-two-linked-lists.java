/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null){
            return null;
        }
        
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        while (l1 != l2){
            
            l1 = l1 == null ? headA : l1.next;
            l2 = l2 == null ? headB : l2.next;
        }
        return l1;
    }
}