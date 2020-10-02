//Queue function using linklist
class Lab2_2_LinkList{
	Node head;
	Node tail;
	int count;
	public Lab2_2_LinkList(){
		head=null;
		tail=null;
		count=0;
	}
	public void enqueue(int n){
		Node newest = new Node(n, null);
		if (count==0){
			head = newest;
			tail = newest;
		}else{
			tail.setNext(newest);
			tail =newest;
		}
		count++;
	}

	public int dequeue(){
		int first = head.getElement();
		if(count>0){
			head = head.getNext();
			count--;
			return first;
		}else{
			return 0;
		}
	}

	public int first(){
		return head.getElement();
	}

	public int las(){
		return tail.getElement();
	}

	public int len(){
		return count;
	}

	public boolean is_empty(){
		if (len()==0) {
			return true;
		}
		return false;
	}
}

class Node{
	int element;
	Node next;
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