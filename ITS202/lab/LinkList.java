public class LinkList{
	Node head;
	Node tail;
	int size;
	public LinkList(){
		head = null;
		tail = null;
		size = 0;
	}

//return the size
	public int size(){
		return size;
	}//return true if node is empty else false
	public boolean isEmpty(){
		if(size()==0){
			return true;
		}return false;
	}//return the first value of node
	public int first(){
		return head.getElement();
	}//return the last value in node
	public int last(){
		return tail.getElement();
	}//will add element to first node(head)
	public void addFirst(int n){
		Node newest = new Node(n, null);
		if(size() == 0){
			head = newest;
			tail = newest;
		}else{
			newest.setNext(head);
			head = newest;
		}
		size +=1;
	}//will add elemnet to last node(tail)
	public void addLast(int n){
		Node newest = new Node(n, null);
		if(size()==0){
			head = newest;
			tail = newest;
		}else{
			tail.setNext(newest);
			tail = newest;
		}
		size +=1;
	}
	public int removeFirst(){
		int deletedElement = head.getElement();
		if(size()==0){
			return 0;
		}else{
			head = head.getNext();
			size -=1;
		}
		return deletedElement;
	}
}

class Node{
	private int element;
	private Node next;
	//constructor
	public Node(int element, Node next){
		this.element = element;
		this.next = next;
	}
	public int getElement(){
		return element;
	}
	public Node getNext(){
		return next;
	}
	public void setElement(int n){
		element = n;
	}
	public void setNext(Node n){
		next = n;
	}
}