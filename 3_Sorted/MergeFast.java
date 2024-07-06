public class MergeFast {
    
    public static void mergesort(int[] org) {
        if (org.length == 0)
          return;
        int[] aux = new int[org.length];
        System.arraycopy(org,0,aux,0, org.length);
        sort(org, aux, 0, org.length -1);
    }
//faster version of merge

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;
            
            // Sort the items from lo to mid (left subarray)
            sort(aux, org, lo, mid);
            
            // Sort the items from mid+1 to hi (right subarray)
            sort(aux, org, mid + 1, hi);
            
            // Merge the two sorted subarrays using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }
   

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // Copy all items from lo to hi from org to aux
    //    for (int k = lo; k <= hi; k++) {
    //        aux[k] = org[k];
    //    }
    
        // Initialize pointers for the two subarrays
        int i = lo;       // Pointer for the first subarray
        int j = mid + 1;  // Pointer for the second subarray
    
        // Merge the two subarrays into org
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // If the first subarray is exhausted, copy from the second subarray
                org[k] = aux[j];
                j++;
            } else if (j > hi) {
                // If the second subarray is exhausted, copy from the first subarray
                org[k] = aux[i];
                i++;
            } else if (aux[i] <= aux[j]) {
                // If the element in the first subarray is smaller or equal, copy from it
                org[k] = aux[i];
                i++;
            } else {
                // If the element in the second subarray is smaller, copy from it
                org[k] = aux[j];
                j++;
            }
        }
    }

    public static void main(String[] arg) {

        int [] a = {8, 33, 78, 9, 121, 76, 84, 31, 90, 0};

        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        
        mergesort(a);
        System.out.println();

        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}