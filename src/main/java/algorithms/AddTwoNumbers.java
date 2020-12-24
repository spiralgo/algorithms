package algorithms;

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

        ListNode theFirstLinkedList = new ListNode(2);
        theFirstLinkedList.append(4).append(3);

        ListNode theSecondLinkedList = new ListNode(5);
     

        AddTwoNumbers a = new AddTwoNumbers();

        ListNode result = a.addTwoNumbers(theFirstLinkedList, theSecondLinkedList);

        LinkedList linkedList = new LinkedList();
        linkedList.head = result;
        LinkedList.traverse(LinkedList.head);
    }
}
