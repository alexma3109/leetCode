public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
		public Node(int k, int v){
			key = k;
			value = v;
			prev = null;
			next = null;
		}
	}
	
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);    
    
    public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;        
    }
    
    public int get(int key) {
		if(!map.containsKey(key)){
			return -1;
		}
		
		Node current = map.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		move_to_tail(current);
		return map.get(key).value;        
    }
    
    public void set(int key, int value) {
		if(get(key) != -1){
			map.get(key).value = value;
			return;
		}
		
		if(map.size() == capacity){
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		
		Node insert = new Node(key, value);
		map.put(key, insert);
		move_to_tail(insert);        
    }
    
    private void move_to_tail(Node current){
		tail.prev.next = current;
		current.prev = tail.prev;
		tail.prev = current;
		current.next = tail;
	}
}