import java.util.Scanner;
public class q1_Selection_sorting{
	public static void main(String[] args){
		Scanner en = new Scanner(System.in);
		System.out.println("Enter the array size.");
		sort obj = new sort(en.nextInt());
		
		obj.setelement();

		System.out.println("Initaial array ");
		for(int i=0;i<obj.array.length;i++){
			System.out.print(obj.array[i]+" ");
		}
		System.out.println("\n");

		obj.selection();

		System.out.println("Sorted array is: ");
		for(int j=0;j<obj.array.length;j++){
			System.out.print(+obj.array[j]+" ");
		}
		System.out.println("\n");
	}
}


class sort{
	int length;
	int stor;
	int[] array = new int[length];

	public sort(int len){
		length = len;
		array = new int[length];
	}
	public void setelement(){
		Scanner en = new Scanner(System.in);
		System.out.println("Enter the element in the array.");
		for(int i=0;i<array.length;i++){
			array[i] = en.nextInt();

		}
	}
	public int[] selection(){
        for (int i = 0; i<array.length-1; i++) 
        {
        	int min = i;
            for (int j =i+1; j < array.length; j++){
                if (array[j] < array[i]){ 
                	min = j; 
                }
                if(min != i){
                	int stor = array[i]; 
            		array[i] = array[j]; 
            		array[j] = stor;
                }
            }

        } 
		return array;
	}
}