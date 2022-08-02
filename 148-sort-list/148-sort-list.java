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

// Iterative solution with constant space complexity
class Solution {
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        int len = getCount(start);
        for (int size = 1; size < len; size*= 2){
            tail = dummyHead;
            while (start != null){
                if (start.next == null){
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }
    
    // split the list in 'size' chunks
    private ListNode split(ListNode start, int size){
        ListNode slow = start;
        ListNode fast = start.next;
        for (int i = 1; i < size && (slow.next != null || fast.next != null); i++){
            
            if(fast.next != null){
                fast = fast.next.next != null ? fast.next.next : fast.next;
            }
            if (slow.next != null){
                slow = slow.next;
            }
        }
        ListNode mid = slow.next;
        slow.next = null;
        nextSubList = fast.next;
        fast.next = null;
        
        return mid;
    }
    // merge the two lists in sorted order 
    private void merge(ListNode l1, ListNode l2){
        
        ListNode dummyHead2 = new ListNode();
        ListNode newTail = dummyHead2;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                newTail.next = l1;
                l1 = l1.next;
            } else {
                newTail.next = l2;
                l2 = l2.next;
            }
            newTail = newTail.next;
        }
        
        if (l1 != null){
            newTail.next = l1;
        }else {
            newTail.next = l2;
        }
        
        while(newTail.next != null){
            newTail = newTail.next;
        }
        
        tail.next = dummyHead2.next;
        tail = newTail;
        
    }
    
    private int getCount(ListNode head){
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}