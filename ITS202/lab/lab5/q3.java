import java.util.Scanner;
public class q3{
	public static void search(int[] a,int x){
		int y = 0,i;
		for(i=0;i<a.length;i++){
			if(x==a[i]){
				y = 1;
				break;
			}
		}

		if(y==1){
			System.out.println("Search found at index "+i);
		}else{
			System.out.println("No match found.  ");
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.print("Enter the number you want to search: ");
		int x = cin.nextInt();
		int[] a={1,3,4,5,6,7,9};
		search(a,x);
	}
}