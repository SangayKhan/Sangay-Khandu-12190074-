public class q1{
	public static void main(String[] args){	
		char[] a = {'!','a','b','c','d','e','e','e','f','a','b'};

		int N = a.length;//10
		int R = 256;

		char[] aux = new char[N];		

		int[] count = new int[R+1];//7
		for (int i = 0; i < N; i++){
			count[a[i] + 1]++;//98//
		}
		for (int r = 0; r < R; r++){
			count[r+1] += count[r];//
		}
		for (int i = 0; i < N; i++){
			aux[count[a[i]]++] = a[i];
		}
		for (int i = 0; i < N; i++){
			a[i] = aux[i];
		}

		for (int i=0;i<N;i++) {
			System.out.println(a[i]+" ");
		}
	}
}