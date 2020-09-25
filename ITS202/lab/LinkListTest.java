public class LinkListTest{
	public static void main(String[] args){
		LinkList obj = new LinkList();
		obj.addFirst(1);
		obj.addLast(2);
		obj.addLast(3);

		assert(obj.size()==3);
		assert(obj.isEmpty()==false);
		assert(obj.first()==1);
		assert(obj.last()==3);
		assert(obj.removeFirst()==1);
		assert(obj.size()==2);
		assert(obj.first()==2);
		System.out.println("All test cases passed");
	}
}