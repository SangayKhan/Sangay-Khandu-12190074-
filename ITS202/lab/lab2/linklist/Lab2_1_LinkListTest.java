//stack function using linklist
public class Lab2_1_LinkListTest{
	public static void main(String[] args) {
		Lab2_1_LinkList obj = new Lab2_1_LinkList();

		obj.push(1);
		obj.push(30);
		obj.push(3);
		obj.push(4);
		obj.push(9);
		obj.push(7);

		System.out.println("First element is: "+obj.top());
		System.out.println("Number of element is: "+obj.size());
		System.out.println("Element removed is: "+obj.pop());

		System.out.println("First element after pop is: "+obj.top());
		System.out.println("Last element after pop is: "+obj.tail.getElement());
		System.out.println("Number of element after pop is: "+obj.size());
	}
}