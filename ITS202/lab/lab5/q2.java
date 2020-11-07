public class q2{
	public static void main(String[] args) {
		String[] a = {"pema","lama","Dema","John","Jams"};

		sort(a);
	}


	public static void sort(String[] a){
		int N = a.length;
		int W = 4;
		int R = 256;
		String[] aux = new String[N];
		for (int d = W-1; d >= 0; d--){
			int[] count = new int[R+1];
			for (int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;
			}
			for (int r = 0; r < R; r++){
				count[r+1] += count[r];
			}
			for (int i = 0; i < N; i++){
				aux[count[a[i].charAt(d)]++] =a[i];
			}
			for (int i = 0; i < N; i++){
				a[i] = aux[i];
			}
		}
		for (int i=0;i<N ;i++) {
			System.out.println(a[i]+" ");
		}
	}
}