package algorithms.datastructures;

import java.util.List;

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
    public static void printList(ListNode k)
    {
        while(k!= null)
        {
            System.out.print(k.val + " ");
            k = k.next;
        }
        System.out.println();
    }
}
