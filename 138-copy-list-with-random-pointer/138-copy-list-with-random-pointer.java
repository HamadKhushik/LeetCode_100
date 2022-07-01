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
        
        if (head == null){
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node head2 = head;
        Node clone_head = new Node(head2.val);
        map.put(head2, clone_head);
        head2 = head2.next;
        
        while(head2 != null){
            Node curr = new Node(head2.val);
            map.put(head2, curr);
            head2 = head2.next;
        }
        
        head2 = head;
        while(head2 != null){
            Node head2_next = head2.next;
            Node head2_random = head2.random;
            Node clone = map.get(head2);
            clone.next = map.get(head2.next);
            clone.random = map.get(head2.random);
            
            head2 = head2.next;
        }
        return clone_head;
    }
}