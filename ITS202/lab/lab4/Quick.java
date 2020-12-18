public class Quick {

    int part(int arr[], int lo, int hi) { 
    
        int pvt=arr[hi];
        int i=(lo-1);  
        for(int k=lo; k<hi; k++)
        {    
            if(arr[k]<pvt)
            {
                i++;
                //swapping the element if i into k
                int tempt=arr[i];
                arr[i]= arr[k];
                arr[k]=tempt;
            }

        }
        int tempt= arr[i+1];
        arr[i+1]= arr[hi];
        arr[hi] = tempt;

        return i+1;
    }
    
    void sort(int[] arr, int lo, int hi) 
    {
        if (lo < hi) {
            int poi = part(arr, lo, hi);
            sort(arr, lo, poi - 1);
            sort(arr, poi + 1, hi);
        }
    }
    
    static void show(int[] arr) {
        int x = arr.length;
        for (int i = 0; i < x; i++) {
            System.out.print(arr[i] + "");
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        int[] arr = { 4, 1, 6, 7 };
        System.out.print("the given array was:");
        show(arr);
        int x = arr.length; 

        Quick obj = new Quick();
        obj.sort(arr, 0, x-1);
        
        
        //Quick.sort(arr);
        System.out.print("Sorted array with the quick sorting was:");
        show(arr);
        // assert isSorted(a);

    }

}
