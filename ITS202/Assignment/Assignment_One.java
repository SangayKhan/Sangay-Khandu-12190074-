public class ArrayListTest{
	public static void main(String[] args){
		ArrayList obj = new ArrayList(4);
		obj.add(1);
		obj.add(2);
		obj.add(3);

		System.out.println("Elements of array:"); 
		for (int i = 0; i < obj.size; i++) { 
			System.out.println(obj.array[i] + " "); 
		}
		System.out.println("size of the element is "+obj.size);
		System.out.println("length of the element is "+obj.array.length);
	}
}

class ArrayList{
	int size;
	int count = 0;
	int full_1over4;
	int full_3over4;
	int[] array;

	public ArrayList(int length){
		size = length;
		array = new int[size];
		full_1over4 = (25*length)/100;
		full_3over4 = (75*length)/100;
	}

	public void add(int add_ele)
	{
		// if(count > 0){
		// 	shrinkSize();
		// }
		if(count!=size){
			array[count] = add_ele;
			count++;
			resize();
		}else{
			size = count+1;
			int[] temp = new int[size];
			for(int i=0;i<size;i++){
				temp[i]=array[i];
			}
			array = temp;
			count++;
		}	
	}

	public void pop()
	{
		if(count > 0){
			// shrinkSize();
            array[count] = 0; 
            count--; 
        } 	
	}

	public void resize()
	{
		if(count == full_1over4){
			int[] temp = new int[size/2];
			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}
			size = size/2;
			array = temp;
		}else if(count == full_3over4){
			int[] temp = new int[size*2];
			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}
			size = size*2;
			array = temp;
		}else{
			size();
		}	
	}

	public int size()
	{
		return size;
	}

	public String toString()
	{
		String s=Integer.toString(size);
		return s;
	}

	// public void shrinkSize() 
 //    { 
 //        int temp[] = null; 
 //        if (count > 0) { 
 //            temp = new int[count]; 
 //            for (int i = 0; i < count; i++) {  
 //                temp[i] = array[i]; 
 //            } 
  
 //            size = count; 
 //            array = temp; 
 //        } 
 //    } 
}
