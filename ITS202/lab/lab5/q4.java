import java.util.Scanner;
public class q4{
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}

	public static void merge(int[] a,int lo,int mid,int hi){
		int[] aux = new int[a.length];

		for(int k=lo;k<=hi;k++){
			aux[k] = a[k];
		}

		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}

	public static void sort(int[] a,int lo,int hi){
		if(hi<=lo) return; 
		int mid = (lo+hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}

	public static void search(int[] a,int x){
		sort(a,0,a.length-1);
		int i=0,y;
		for(y=0;y<a.length;y++){
			if(x==a[y]){
				i = 1;
				break;
			}
		}

		if(i==1){
			System.out.println("Element fount in index "+y);
		}else{
			System.out.println("Element not found");
		}
	}

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int x = cin.nextInt();
		int[] a = {1,2,8,5,6,9,3};
		search(a,x);	
	}
}
