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
        Node iter = head;
        // first pass, build the map of the nodes
        while(iter != null){
            Node curr = new Node(iter.val);
            map.put(iter, curr);
            iter = iter.next;
        }
        
        iter = head;
        // second pass, build the connections/pointers of the nodes
        while(iter != null){
            Node iter_next = iter.next;
            Node iter_random = iter.random;
            Node copy = map.get(iter);
            copy.next = map.get(iter.next);
            copy.random = map.get(iter.random);
            
            iter = iter.next;
        }
        // Node pseudohead = map.get(head); // return the copied head from map
        return map.get(head);
    }
}