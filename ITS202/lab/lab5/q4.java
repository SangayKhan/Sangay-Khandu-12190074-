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

	public static int search(int[] a,int x,int lo,int hi){
		sort(a,0,a.length-1);
		if(hi<lo) return 0;
		int y,i=0;
		int mid=(lo+hi)/2;
		for(y=0;y<a.length;y++){
			if(x>a[mid]){
				search(a,x,mid+1,hi);
			}else if(x<a[mid]){
				search(a,x,lo,mid);
			}else{
				i=1;
				return i;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int x = cin.nextInt();
		int[] a = {1,2,8,5,6,9,3};
		//int i = 0;
		//search(a,x,0,a.length-1,i);
		if(search(a,x,0,a.length-1)==1){
			System.out.println("Element fount.");
		}else{
			System.out.println("No element.");
		}
	}
}
