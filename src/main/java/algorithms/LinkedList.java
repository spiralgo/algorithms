package algorithms;
 
public class LinkedList { 

	ListNode head;  
        
   
 
	public static LinkedList insert(LinkedList list, int data) 
	{  
		ListNode new_node = new ListNode(data); 
		new_node.next = null; 
 
		if (list.head == null) { 
			list.head = new_node; 
		} else { 
 
			ListNode last = list.head; 
			while (last.next != null) { 
				last = last.next; 
			} 
 
			last.next = new_node; 
		} 
 
		return list; 
	} 
 
	public static void printList(LinkedList list) 
	{ 
		ListNode currNode = list.head; 

		System.out.print("LinkedList: "); 
 
		while (currNode != null) { 
		 
			System.out.print(currNode.val + " "); 

		 
			currNode = currNode.next; 
		} 
	} 
 
	public static void main(String[] args) 
	{  
		LinkedList list = new LinkedList(); 
 
		list = insert(list, 1); 
		list = insert(list, 2); 
		list = insert(list, 3); 
		list = insert(list, 4); 
		list = insert(list, 5); 
		list = insert(list, 6); 
		list = insert(list, 7); 
		list = insert(list, 8); 
 
		printList(list); 
	} 
        
        
} 
