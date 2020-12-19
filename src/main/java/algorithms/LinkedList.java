package algorithms;

public class LinkedList {

    ListNode head;

    public LinkedList insert(int data) {

        ListNode new_node = new ListNode(data);
        new_node.next = null;

        if (this.head == null) {
            this.head = new_node;
        } else {

            ListNode pointerToFindTheLast = this.head;
            while (pointerToFindTheLast.next != null) {
                pointerToFindTheLast = pointerToFindTheLast.next;
            }

            pointerToFindTheLast.next = new_node;
        }

        return this;
    }

    public LinkedList delete(int data) {
        if (this.head != null) {

            ListNode pointer = this.head;
            
            if (pointer.val == data) {
                this.head = pointer.next;

            } else {
                while (pointer.next != null) {
                    ListNode previous = pointer;
                    pointer = pointer.next;

                    if (pointer.val == data) {
                        previous.next = pointer.next;
                        break;
                    }
                }
            } 
        }
        return this;
    }

    public LinkedList update(int data, int newData) { 
        if (this.head != null) {

            ListNode pointer = this.head;
            
            if (pointer.val == data) {
                this.head.val = newData;

            } else {
                while (pointer.next != null) { 
                    pointer = pointer.next;

                    if (pointer.val == data) {
                        pointer.val = newData;
                        break;
                    }
                }
            } 
        }
        return this;
    }


    public static void printList(LinkedList list) {
        ListNode currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {

            System.out.print(currNode.val + " ");

            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        list.update(4, 9);

        printList(list);
    }

}
