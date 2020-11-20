public class SequentialSearchSTTest{
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> obj = new SequentialSearchST<String, Integer>();

		obj.put("A",5);
		obj.put("B",7);
		obj.put("C",8);
		obj.put("D",9);
		obj.put(null,6);
		System.out.println(obj.size());
		System.out.println(obj.isEmpty());
		System.out.println(obj.contains("A"));
		System.out.println(obj.get("A"));
		obj.delete("A");
		System.out.println(obj.get("A"));
		System.out.println(obj.get("B"));
		System.out.println(obj.get("C"));
	}
}
