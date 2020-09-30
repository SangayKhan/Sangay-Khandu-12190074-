import java.lang.Math;
public class LinkedListTest{
	public static void main(String[] args){
		int initial = 10;
		ArrayList obj = new ArrayList(initial);

		//adding element to the array
		//need to warn the program if the add() is called more than the size 
		//if(obj.count == obj.size){
			System.out.println("All space full in array");
		//}else{
			obj.add(1);
			obj.add(1);

		//}


		//element in the array before shrinking
		System.out.println("Elements in array before:");

		for (int i = 0; i < obj.size; i++) { 
			System.out.print(obj.array[i] + " "); 
		}

		//size of the element before shrinking
		System.out.println("\nsize of the array before is "+obj.size);
		System.out.println("Number of element in array bofore is "+obj.count);

		//removing the last element of the array
		obj.pop();

		//element in the array after removing last element
		System.out.println("\nElements in array after pop:");

		for (int i = 0; i < obj.size; i++) { 
			System.out.print(obj.array[i] + " "); 
		}

		//size of the element after removing last element
		System.out.println("\nsize of the array after pop "+obj.size);
		System.out.println("Number of element in array after pop is "+obj.count);

		//make size as that of number of element in array 
		obj.check();
		//obj.constant(constant);
		obj.resize();

		

		//size of the element after shrinking
		System.out.println("\nElements in array after:");

		if(obj.size!=initial){

			for (int i = 0; i < obj.size; i++) { 
				System.out.print(obj.array[i] + " "); 
			}

			System.out.println("\nsize of the array has changed as array is full by 1/4 or 3/4 is "+obj.size);
		
		}else{

			for (int i = 0; i < obj.size; i++) { 
				System.out.print(obj.array[i] + " "); 
			}
			System.out.println("\nsize of the array remains same that is "+obj.size);
		}
		System.out.println("Number of element in array after is "+obj.count);
	}
}

class ArrayList{
	int size;//initial_size;//,constant;
	int count = 0;
	int full_1over4;
	int full_3over4;
	int[] array;

	public ArrayList(int length){
		size = length;
		array = new int[size];
		full_1over4 = Math.round((25*length)/100);
		full_3over4 = Math.round((75*length)/100);
	}

	//will add new element in the array
	public void add(int add_ele)
	{
		array[count] = add_ele;
		count++;
	}
	//remove the last element
	public void pop()
	{
		if(count > 0){
            array[count-1] = 0; 
            count--; 
        } 	
	}

	public int size(){
		return size;
	}
	//resize the size of array to double if array is full by 75% and half if 25% full
	public void resize()
	{
		if(count == full_1over4){

			int[] temp = new int[size/2];

			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}

			size = size/2;
			array = temp;
		}

		if(count == full_3over4){

			int[] temp = new int[size*2];

			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}

			size = size*2;
			array = temp;
		}	
	}

	public int check()
	{
		return count;
	}

	public String toString()
	{
		String s=Integer.toString(size);
		return s;
	} 
}
