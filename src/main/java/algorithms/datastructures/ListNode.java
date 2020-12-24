package algorithms.datastructures;

public class ListNode {

    public int val;
    public ListNode next;
   
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

   public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
 
    public ListNode append(int nextVal){
        ListNode next = new ListNode(nextVal);
        
        this.next = next;
        
        return this.next;
    }
}
