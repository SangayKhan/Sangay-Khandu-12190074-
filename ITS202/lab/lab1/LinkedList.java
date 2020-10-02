public class LinkedList{
	Node head;
	Node tail;
	int size;
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	//to get the size of the list
	public int size(){
		return size;
	}
	//to see if the list is empty
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}
	// to get the first element of the list
	public int first(){
		return head.getElement();
	}
	
	//to get the last element of the list 
	public int last(){
		return tail.getElement();
	}

	// to add an element to the head of the list
	public void addFirst(int n){
		Node newest = new Node(n, null);

		if (size == 0){
			 head = newest;
			 tail = newest;
		}else{
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	// to add an element to the tail of the list
	public void addLast(int n){
		Node newest = new Node(n, null);
		if (size == 0) {
			head = newest;
			tail = newest;
		}else{
			tail.setNext(newest);
			tail =newest;
		}
		size += 1;
	}

	// to return and remove the first element of the list
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size == 0) {
			return 0;
		}else{
			head = head.getNext();
			size = size -1;
		}
		return deletedElement;
	}



}

class Node{
	private int element;
	private Node next;
	
	// constructor
	public Node(int element, Node next ){
	    this.element = element;
		this.next = next;
	}

	// getElement() to return element 
	public int getElement(){
		return element;
	}

	// getNext() to return address
	public Node getNext(){
		return next;
	}

	//  setElement() to return element n
	public void setElement(int n){
		element = n;
	}

	// setNext() to return address n
	public void setNext(Node n){
		next = n;
	}
}