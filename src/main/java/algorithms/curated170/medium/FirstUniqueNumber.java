package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.Map;

class FirstUniqueNumber {
    private static class Node {
        int val;
        Node prev;
        Node next;
        boolean active = true;
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public FirstUniqueNumber(int[] nums) {
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<>(nums.length * 2);
        for(int n : nums) {
            add(n);
        }
    }
    
    public int showFirstUnique() {
        while(head.next != tail) {
            return head.next.active ? head.next.val : -1;
        }
        return -1;
    }
    
    public void add(int value) {
        if(!map.containsKey(value)) {
            Node node = new Node();
            node.val = value;
            
            map.put(value, node);
            
            node.next = tail;
            node.prev = tail.prev;
            
            node.prev.next = node;
            tail.prev = node;
        } else {
            Node node = map.get(value);
            if(node.active) {
                node.active = false;
                
                Node prev = node.prev;
                Node next = node.next;
                
                prev.next = next;
                next.prev = prev;
                
            }
        }
    }
}
