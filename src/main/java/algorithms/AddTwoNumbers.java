/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ASUS
 */
public class AddTwoNumbers {
       public ListNode addTwoNumbers(ListNode theFirstLinkedList, ListNode theSecondLinkedList) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while (theFirstLinkedList != null || theSecondLinkedList != null) {
            int x = (theFirstLinkedList != null) ? theFirstLinkedList.val : 0;
            int y = (theSecondLinkedList != null) ? theSecondLinkedList.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (theFirstLinkedList != null) theFirstLinkedList = theFirstLinkedList.next;
            if (theSecondLinkedList != null) theSecondLinkedList = theSecondLinkedList.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }
       public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4, new ListNode(3));
        
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6, new ListNode(4));
      
        
        AddTwoNumbers a = new AddTwoNumbers();
    
        ListNode result =  a.addTwoNumbers(l1, l2);
        
        LinkedList linkedList = new LinkedList();
        linkedList.head = result;
        LinkedList.traverse(LinkedList.head);
    }
}
 
 