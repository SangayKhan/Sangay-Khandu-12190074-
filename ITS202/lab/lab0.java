public class lab0{
	public static int[] resize(int n,int[] array){
		int[] value = new int[4];
		for(int i=0;i<array.length;i++){
			value[i] = array[i];
		}
		value[n-1] = 4;
		return value;
	}
	public static void main(String args[]){
		int[] array = {1,2,3};
		int[] tem = resize(4,array);
		for(int i = 0; i<tem.length;i++){
			System.out.println(tem[i]);
		}
	}
}