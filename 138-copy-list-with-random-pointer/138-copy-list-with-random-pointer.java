/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Node iter = head; 
        Node next = null;
        // first pass, copy the nodes
        while(iter != null){
            next = iter.next;
            
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            
            iter = next;
        }
        
        iter = head;
        // second pass, make the random connections/pointers
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        iter = head;
        Node pseudohead = new Node(0);
        Node copy, copyIter = pseudohead;
        // third pass, separate the two lists
        while (iter != null){
            next = iter.next.next;
            
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            
            iter.next = next;
            iter = next;
        }
        return pseudohead.next;
    }
}