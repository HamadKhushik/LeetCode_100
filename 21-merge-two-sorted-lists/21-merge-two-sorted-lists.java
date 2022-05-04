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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode list3 = new ListNode();
        ListNode head3 = list3;
        
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                list3.next = list1;
                list1 = list1.next;
            } else if (list1.val >= list2.val){
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        if (list1 != null){
            list3.next = list1;
        } else if (list2 != null){
            list3.next = list2;
        }
        return head3.next;
    }
}