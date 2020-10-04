import java.lang.Math;
import java.util.Arrays;
public class ArrayList<T>{
	int size;
	int count = 0;
	int full_1over4;
	int full_3over4;
	Object[] array;

	public ArrayList(int length){
		size = length;
		array = new Object[size];
		full_1over4 = Math.round((25*length)/100);
		full_3over4 = Math.round((75*length)/100);
	}

	//will add new element in the array
	public void add(T add_ele, Object[] array)
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
	//return the size of the array
	public int size(){
		return size;
	}
	//resize the size of array to double if array is full by 75% and half if 25% full
	public void resize()
	{
		if(count == full_1over4){

			Object[] temp = new Object[size/2];

			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}

			size = size/2;
			array = temp;
		}

		if(count == full_3over4){

			Object[] temp = new Object[size*2];

			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}

			size = size*2;
			array = temp;
		}	
	}
	//retunr size of the array in staing type
	public String toString()
	{
		String temp = Arrays.toString(array);
		return temp; 
	}

	public static void main(String[] args){
		ArrayList<Integer> obj = new ArrayList<>(10);

		//adding element to the array
		obj.add(1, obj.array);
		obj.add(2, obj.array);
		obj.add(3, obj.array);
		obj.add(4, obj.array);

		assert(obj.size()==10);
		assert(obj.toString().equals("[1, 2, 3, 4, null, null, null, null, null, null]"));
		System.out.println("All test pass. ");
	}
}
