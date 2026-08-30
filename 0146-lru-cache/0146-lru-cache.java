class LRUCache {
    class Node{
        int key , value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value=value;

        }

    }
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        map=new HashMap<>();
        head= new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
        
    }
    public void add(Node node){
        Node prevNode= tail.prev;
        prevNode.next= node;
        node.prev= prevNode;
        node.next= tail;
        tail.prev= node;
    }

    public void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next= nextNode;
        nextNode.prev= prevNode;



    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value=value;
            add(node);
            return;
        }
        Node node=new Node(key,value);
        map.put(key,node);
        add(node);
        if(map.size() > capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */