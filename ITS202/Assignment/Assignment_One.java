import java.lang.Math;
public class ArrayListTest{
	public static void main(String[] args){
		int initial = 4;
		ArrayList obj = new ArrayList(initial);

		//adding element to the array
		obj.add(1);

		
		//element in the array before shrinking
		System.out.println("Elements of before array:"); 
		for (int i = 0; i < obj.size; i++) { 
			System.out.println(obj.array[i] + " "); 
		}

		//size of the element before shrinking
		System.out.println("size of the array before is "+obj.size);
		System.out.println("Number of element in array bofore is "+obj.count);

		int constant = obj.size();
		obj.constant(constant);
		obj.resize();

		

		//size of the element after shrinking
		if(obj.size!=initial){
			//element in the array after shrinking
			System.out.println("Elements of after array:"); 
			for (int i = 0; i < obj.size; i++) { 
				System.out.println(obj.array[i] + " "); 
			}
			System.out.println("size of the has changed as array is full by 1/4 or 3/4 is "+obj.size);
		}else{
			System.out.println("Elements of after array:"); 
			for (int i = 0; i < obj.size; i++) { 
				System.out.println(obj.array[i] + " "); 
			}
			System.out.println("size of the element remains same that is "+obj.size);
		}
		System.out.println("Number of element in array after is "+obj.count);
	}
}

class ArrayList{
	int size,initial_size,constant;
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

	public void add(int add_ele)
	{
		if(count!=size){
			array[count] = add_ele;
		}else{	
			int[] temp = new int[size+1];
			for(int i=0;i<size;i++){
				temp[i]=array[i];
			}
			array = temp;
			array[count] = add_ele;
		}
		count++;	
	}

	public void pop()
	{
		if(count > 0){
			// shrinkSize();
            array[count] = 0; 
            count--; 
        } 	
	}

	public int constant(int constant){
		this.constant = constant;
		return constant;
	}

	public void resize()
	{
		if(constant == full_1over4){
			int[] temp = new int[size/2];
			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}
			size = size/2;
			array = temp;
		}

		if(constant == full_3over4){
			int[] temp = new int[size*2];
			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}
			size = size*2;
			array = temp;
		}	
	}

	public int size()
	{
		shrinkSize();
		return initial_size;
	}

	public String toString()
	{
		String s=Integer.toString(size);
		return s;
	}

	public void shrinkSize() 
    { 
    	//if(constant == full_1over4 || constant == full_3over4){
    		int temp[] = null; 
        	if (count > 0) { 
            	temp = new int[count]; 
            	for (int i = 0; i < count; i++) {  
                	temp[i] = array[i]; 
            	} 
            	initial_size = count; 
            	array = temp; 
    		}
       // } 
    } 
}
