import java.util.Scanner;
public class q1_Insertion_sorting{
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

		obj.insertion();

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
	public int[] insertion(){
		for(int i=0;i<array.length;i++){
			for(int j=i;j>0 && compare(j-1,j,array);j--){
				swap(j-1,j,array);
			}
		}
		return array;
	}
	public boolean compare(int a,int b,int[] array){
		if(array[a]>array[b]){
			return true;
		}
		return false;
	}
	public void swap(int a,int b,int[] array){
		int stor = array[a];
		array[a]=array[b];
		array[b]=stor;
	}
}