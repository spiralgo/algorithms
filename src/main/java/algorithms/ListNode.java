package algorithms;

public class ListNode {

    int val;
    ListNode next;
   
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
 
    ListNode append(int nextVal){
        ListNode next = new ListNode(nextVal);
        
        this.next = next;
        
        return this.next;
    }
}
