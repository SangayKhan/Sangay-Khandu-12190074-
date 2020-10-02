//Stack function using array
public class Lab2_1_array{
	public static void main(String[] args){
		Lab2 obj = new Lab2(5);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);

		System.out.println("Element in the array are: ");
		for(int i=0;i<obj.count;i++){
			System.out.print(obj.array[i]+" ");
		}

		System.out.println("\nThe first element is "+obj.top());
		System.out.println("the size of the array is "+obj.size());
	
		System.out.println("\nThe poped element is: "+obj.pop()+"\n");
		//after pop
		System.out.println("Element in the array after pop are: ");
		for(int i=0;i<obj.count;i++){
			System.out.print(obj.array[i]+" ");
		}
		System.out.println("\nThe first element after pop is "+obj.top());
		System.out.println("The size of the array after pop is "+obj.size());
	}

}

class Lab2{
	int add_element;
	int size;
	int count=0;
	int[] array;

	public Lab2(int size){
		this.add_element = add_element;
		this.size = size;
		array = new int[size];
	}

	public void push(int add_element){
		array[count]=add_element;
		count++;
	}

	public int pop(){
		int last_ele = array[count-1];
		if(count>0){
			array[count-1]=0;
			count--;
			int[] temp = new int[count];
			for(int i=0;i<count;i++){
				temp[i]=array[i];
			}
			array = temp;
		}else{
			return 0;
		}
		return last_ele;
	}

	public int top(){
		if(count>0){
			return array[count-1];
		}else{
			return 0;
		}
	}

	public int size(){
		return count;
	}
	 public boolean isEmpty(){
	 	if(count==0){
	 		return true;
	 	}else{
	 		return false;
	 	}
	}
}
