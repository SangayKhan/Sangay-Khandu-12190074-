//Queue function using linklist
public class Lab2_2_LinkListTest{
	public static void main(String[] args) {
		Lab2_2_LinkList obj = new Lab2_2_LinkList();

		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		System.out.println("First element is: "+obj.first());
		System.out.println("Number of element is: "+obj.len());
		System.out.println("Element removed is: "+obj.dequeue());

		System.out.println("First element after pop is: "+obj.first());
		System.out.println("Last element after pop is: "+obj.las());
		System.out.println("Number of element after pop is: "+obj.len());
	}
}