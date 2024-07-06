public class QuickSortArray {

    int [] array;
    int size;

    public QuickSortArray (int size) {
        this.size = size;
        array = new int[size];
    }


    public void sort(int []array, int start, int end) {

        if(end <= start)
            return;
        
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);    

    }

    public int partition(int []array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;
        
        for(int j = start; j <= end - 1; j++) {
            if(array[j] < pivot) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        i++;
        int aux = array[i];
        array[i] = array[end];
        array[end] = aux;

        return i;
    }    

 /*    public static void main (String args[]) {

        int [] a = {99, 5, 78, 6, 3, 12, 0, 100, 55};
        sort(a, 0, a.length - 1);

        for(int i = 0; i < a.length; i++) 
            System.out.print(a[i] + " ");

    }*/

}