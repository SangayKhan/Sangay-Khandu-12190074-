public class Assignment_One{ 
	private int array[]; 
	private int count; 
	private int size; 

	public Assignment_One(){ 
		array = new int[4]; 
		count = 0; 
		size = 4; 
	} 

	public void add(int data){ 
		if (count == 2){ 
			growSize();
		}else if(count == 0 ){
			shrinkSize();
		}else{
			size();
		}
		array[count] = data; 
		count++;//will it increment all the method or only the add mehtod 
	} 

	public void growSize() { 
		int temp[] = null; 
		if (count == 2){ 
			temp = new int[size * 2]; 
			{ 
				for (int i = 0; i < size; i++) { 
					temp[i] = array[i]; 
				} 
			} 
		} 
		array = temp; 
		size = size * 2; 
	} 

	public void shrinkSize() { 
		int temp[] = null; 
		if (count == 0){ 
			temp = new int[size/2]; 
			for (int i = 0; i < count; i++) { 
				temp[i] = array[i]; 
			} 
			size = size/2; 
			array = temp; 
		} 
	} 

 	public void remove(){ 
		if (count > 0){ 
			array[count - 1] = 0; 
			count--; 
		} 
	}

	public int size(){
		return array.length;
	} 

	public static void main(String[] args) 
	{ 
		Assignment_One da = new Assignment_One(); 

		da.add(1);
		da.add(2);
		da.add(3);
		da.add(4);
		da.add(5);   

		// print all array elements after add 9 elements 
		System.out.println("Elements of array:"); 
		for (int i = 0; i < da.size; i++) { 
			System.out.print(da.array[i] + " "); 
		} 

		System.out.println(); 

		// print size of array and no of element 
		System.out.println("Size of array: " + da.size); 
		System.out.println("No of elements in array: " + 
											da.count); 

		// shrinkSize of array 
		da.shrinkSize(); 

		// print all array elements 
		System.out.println("Elements of array "+ 
				"after shrinkSize of array:"); 
		for (int i = 0; i < da.size; i++) { 
			System.out.print(da.array[i] + " "); 
		} 
		System.out.println(); 

		// print size of array and no of element 
		System.out.println("Size of array: " + da.size); 
		System.out.println("No of elements in array: " + 
											da.count); 

		da.remove(); 

		// print Elements of array after delete last 
		// element 
		System.out.println("Elements of array after" + 
							" delete last element:"); 
		for (int i = 0; i < da.size; i++) { 
			System.out.print(da.array[i] + " "); 
		} 

		System.out.println(); 

		// print size of array and no of element 
		System.out.println("Size of array: " + da.size); 
		System.out.println("No of elements in array: " + 
											da.count);
	} 
} 
