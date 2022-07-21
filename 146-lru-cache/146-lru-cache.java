class LRUCache {
    
    final Map<Integer, Node>  map;
    final Node head = new Node(0, 0);
    final Node tail = new Node(0,0);
    final int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        int res = -1;
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addToHead(n);
            res = n.value;
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            n.value = value;
            addToHead(n);
        } else {
            if(map.size() == capacity){
                map.remove(tail.previous.key);
                remove(tail.previous);
            } 
            Node n = new Node(key, value);
            map.put(key, n);
            addToHead(n);
        }
    }
    
    public void addToHead(Node n){
        n.next = head.next;
        head.next.previous = n;
        head.next = n;
        n.previous = head;
    }
    
    public void remove(Node n){
        n.previous.next = n.next;
        n.next.previous = n.previous;
    }
    
    class Node{
        Node previous, next;
        int value, key;
        
        public Node(int key, int value){
            this.value = value;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */