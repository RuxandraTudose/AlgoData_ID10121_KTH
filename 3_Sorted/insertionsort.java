public class insertionsort {

    public static void swap (int [] array, int i, int j) {

        int aux = array[i];
        array[i] = array[j];
        array [j] = aux;
    }

   /*public static void insersort_fast(int [] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j] ; j--) { //look back one position and check if the neighbours are disordered
                int tmp = array[j];
                array[j]=array[j-1];
                array[j-1] = tmp;
            }
        }
    }*/
//faster version    
    public static void insersort_fast (int [] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j] ; j--) { //look back one position and check if the neighbours are disordered
                swap(array, j-1, j); // if disordered - swap! 
            }
        }
    }
//slower version
    /*public static void insersort (int [] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j] ; j--) { //look back one position and check if the neighbours are disordered
                //swap(array, j, j-1); // if disordered - swap! 
                int tmp = array[j-1];
                array[j-1] = array[j];
                array[j] = tmp;
            }
        }
    }*/

    public static void main(String[] arg) {

        int [] a = {8, 33, 78, 9, 121, 76, 84, 31, 9, 0};
    
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        
        insersort_fast(a);
        System.out.println();
    
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
    
}


 //leave the swap functions - fa interschimbarea in loop
 //fac j-1 la final am valoarea in mana cand fac for si compar conditia