package algorithms.curated170.medium;

public class InsertIntoASortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {
        Node tmp = new Node(insertVal);

        if (head == null) {
            tmp.next = tmp;
            return tmp;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != head) {
            if (pre.val <= insertVal && cur.val > insertVal) {
                break;
            }
            else if (pre.val > cur.val && (insertVal >= pre.val || insertVal <= cur.val)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = tmp;
        tmp.next = cur;

        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
