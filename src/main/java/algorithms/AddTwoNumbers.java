package algorithms;

import algorithms.datastructures.LinkedList;
import algorithms.datastructures.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode theFirstLinkedList, ListNode theSecondLinkedList) {

        ListNode head = new ListNode(0);
        ListNode pointer = head;
        int carry = 0;

        while (theFirstLinkedList != null || theSecondLinkedList != null) {
            int x = (theFirstLinkedList != null) ? theFirstLinkedList.val : 0;
            int y = (theSecondLinkedList != null) ? theSecondLinkedList.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            if (theFirstLinkedList != null) {
                theFirstLinkedList = theFirstLinkedList.next;
            }
            if (theSecondLinkedList != null) {
                theSecondLinkedList = theSecondLinkedList.next;
            }
        }
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode preadvise = new ListNode(2);
       
        preadvise.append(4).append(5).next =  new ListNode(9);
       
        preadvise.next.append(77);
 
    
         LinkedList.traverse(preadvise);
 
 
 
    }
}
