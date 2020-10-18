import java.util.Scanner;
public class q1_Bubble_sorting{
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

		obj.Bubble();

		System.out.println("Sorted array is: ");
		for(int j=0;j<obj.array.length;j++){
			System.out.print(+obj.array[j]+" ");
		}
		System.out.println("\n");
	}
}


class sort{
	int length,sort;
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
	public int[] Bubble(){
        for (int i = 0; i<array.length-1; i++) 
        {  
        	int swap_count = 0;
            for (int j =0; j < array.length-i-1; j++){
                if (array[j] > array[j+1]){ 
                	int stor = array[j]; 
            		array[j] = array[j+1]; 
            		array[j+1] = stor;
            		swap_count = 1;
                }
            }
            if(swap_count == 0){
            	break;
            }
        } 
		return array;
	}
}
