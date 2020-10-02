//stack function using linklist
class Lab2_1_LinkList{
	Node head;
	Node tail;
	int count;
	int second_last;
	public Lab2_1_LinkList(){
		head=null;
		tail=null;
		count=0;
	}
	public void push(int n){
		Node newest = new Node(n,null);
		if (count==0){
			head = newest;
			tail = newest;
		}else{
			tail.setNext(newest);
			second_last = tail.getElement();
			tail =newest;
		}
		count++;
	}

	public int pop(){
		int last = tail.getElement();
		if(count>0){
			Node obj = new Node(second_last, null);
			tail.setNext(obj);
			tail = obj;
			count--;
			return last;
		}else{
			return 0;
		}
	}

	public int top(){
		return head.getElement();
	}

/*	public int las(){
		return second_last;
	}*/

	public int size(){
		return count;
	}

	public boolean isEmpty(){
		if (size()==0) {
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