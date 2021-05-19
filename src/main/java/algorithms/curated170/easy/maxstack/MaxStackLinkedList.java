package algorithms.curated170.easy.maxstack;

 
public class MaxStackLinkedList {
class MaxStack { 
    Node head = null;
    
    /** initialize your data structure here. */
    public MaxStack() {
        Node head = null;
    }
    
    public void push(int x) {
        Node newHead;
        
        // insert a new node, or before previous head node
        if (head == null) {
            newHead = new Node(x, x, null, null);
        } else {
            newHead = new Node(x, Math.max(x, head.max), null, head);
            head.prev = newHead;
        }
        head = newHead;
    }
    
    public int pop() {
        if (head == null) return -1;
        
        // remove current head node
        int val = head.val;
        head = head.next;
        return val;
    }
    
    public int top() {
        return head.val;
    }
    
    public int peekMax() {
        return head.max;
    }
    
    public int popMax() {
        Node currNode = head, prevNode = null;
        
        // traverse to find the top-most element with maximum value
        while (currNode != null && currNode.val != currNode.max) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        // maximum node is head, so simply remove the head node
        if (prevNode == null) head = currNode.next;
        
        // otherwise, remove current node from the linked list, then update all subsequent node's max
        else {
            prevNode.next = currNode.next;
            if (prevNode.next != null) prevNode.next.prev = prevNode;
            
            Node t = prevNode;
            while (t != null) {
                t.max = t.next == null ? t.val : Math.max(t.val, t.next.max);
                t = t.prev;
            }
        }
        
        return currNode.max;
    }
}

class Node {
    int val;
    int max;
    Node prev;
    Node next;
    Node(int val, int max, Node prev, Node next) {
        this.val = val;
        this.max = max;
        this.prev = prev;
        this.next = next;
    }
}
}
