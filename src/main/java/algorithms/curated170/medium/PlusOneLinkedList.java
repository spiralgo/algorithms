package algorithms.curated170.medium;
 
import algorithms.datastructures.ListNode;

public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head)
    {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode lastNonNine = head.val == 9 ? newHead : head;
        ListNode curr = head;
        while(curr != null)
        {
            if(curr.val != 9)
            {
                lastNonNine = curr;
            }
            curr = curr.next;
        }
        lastNonNine.val++;
        curr = lastNonNine.next;
        while(curr != null)
        {
            curr.val = 0;
            curr = curr.next;
        }
        return newHead.val == 0 ? head : newHead;
    }
    public static void main(String[] args) {
        ListNode num = new ListNode(9);
        num.append(9);
        num.next.append(9);
        ListNode.printList(num);
        var solution = new PlusOneLinkedList();
        var plused = solution.addOne(num);
        ListNode.printList(plused);
    }
}
