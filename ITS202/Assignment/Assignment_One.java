import java.lang.Math;
public class ArrayListTest{
	public static void main(String[] args){
		ArrayList obj = new ArrayList(10);
		//adding element to the array
		obj.add(1);
		obj.add(1);
		obj.add(1);
		//element in the array before shrinking
		System.out.println("Elements of before array:"); 
		for (int i = 0; i < obj.size; i++) { 
			System.out.println(obj.array[i] + " "); 
		}
		//size of the element before shrinking
		System.out.println("size of the before element is "+obj.size);
		System.out.println("count of the before element is "+obj.count);

		int constant = obj.size();
		obj.constant(constant);
		obj.resize();
		//element in the array after shrinking
		System.out.println("Elements of after array:"); 
		for (int i = 0; i < obj.size(); i++) { 
			System.out.println(obj.array[i] + " "); 
		}
		//size of the element after shrinking
		System.out.println("size of the element after is "+obj.size);
		System.out.println("count of the element after is "+obj.count);
		System.out.println("constant is "+obj.constant);

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
		// if(count > 0){
		// 	shrinkSize();
		// }
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
        int temp[] = null; 
        if (count > 0) { 
            temp = new int[count]; 
            for (int i = 0; i < count; i++) {  
                temp[i] = array[i]; 
            } 
  
            initial_size = count; 
            array = temp; 
        } 
    } 
}
