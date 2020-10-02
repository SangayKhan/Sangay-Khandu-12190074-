//Queue function using array
public class Lab2_2_array{
	public static void main(String[] args){
		Lab2 obj = new Lab2(5);
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);

		System.out.println("Element in the array are: ");
		for(int i=0;i<obj.count;i++){
			System.out.print(obj.array[i]+" ");
		}

		System.out.println("\nThe first element is "+obj.first());
		System.out.println("the size of the array is "+obj.len());
	
		System.out.println("\nThe poped element is: "+obj.dequeue()+"\n");
		//after pop
		System.out.println("Element in the array after pop are: ");
		for(int i=0;i<obj.count;i++){
			System.out.print(obj.array[i]+" ");
		}
		System.out.println("\nThe first element after pop is "+obj.first());
		System.out.println("The size of the array after pop is "+obj.len());
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

	public void enqueue(int add_element){
		array[count]=add_element;
		count++;
	}

	public int dequeue(){
		int last_ele = array[0];
		if(count>0){
			array[0]=0;
			count--;
			int[] temp = new int[count];
			for(int i=0;i<count;i++){
				temp[i]=array[i+1];
			}
			array = temp;
		}else{
			return 0;
		}
		return last_ele;
	}

	public int first(){
		if(count>0){
			return array[0];
		}else{
			return 0;
		}
	}

	public int len(){
		return count;
	}
	 public boolean is_empty(){
	 	if(count==0){
	 		return true;
	 	}else{
	 		return false;
	 	}
	}
}
