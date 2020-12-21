package algorithms;
 
public class LinkedList {

    static ListNode head;

    static void insert(ListNode newNode) {
        ListNode pointer = head;
        
        while (pointer.next!=null) {            
            pointer = pointer.next;
        }
        pointer.next = newNode;
    }

    static void delete(int deleteVal) {
        ListNode pointer = head;
    
         if(pointer.val == deleteVal){
                 head = pointer.next;
        } else{
          while (pointer.next!=null) {  
           ListNode previous  = pointer;
            pointer = pointer.next;
           
            if(pointer.val == deleteVal){
                previous.next = pointer.next;
                break;
            }    
        }
         }
    }

   static void update(int updateVal, int newVal) {
        ListNode pointer = head;
    
         if(pointer.val == updateVal){
                 head.val = newVal;
        } else{
          while (pointer.next!=null) {  
       
            pointer = pointer.next;
           
            if(pointer.val == updateVal){
                pointer.val = newVal;
                break;
            }    
        }
         }
    }
   

    
     static void traverse(ListNode head) {
        if(head!=null){
             ListNode pointer = head;
        
        StringBuilder sb = new StringBuilder();
        
        while (pointer.next!=null) {    
            sb.append(pointer.val).append(", ");
            pointer = pointer.next;
            
        }
          sb.append(pointer.val);
          
          System.out.println(sb.toString());
        }
       
    }
    
    public static void main(String[] args) {
        head = new ListNode(27);
 
        insert(new ListNode(28));
 
        insert(new ListNode(29));
 
        insert(new ListNode(30));
     
        update(29, 31);
        
        traverse(head);
    }

}
