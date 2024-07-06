import java.util.Random;

public class Bench {

    //generate an unsorted array of keys to look for in an array
    public static int[] keys(int n) {
        Random rnd = new Random();	
        int[] indx = new int[n];

        for (int i = 0; i < n ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }	

        return indx;
    }

   
    public static void main(String[] arg) {

        int[] sizes = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,11000,12000,13000,14000,15000,16000};
       
        System.out.printf("# sorting an array of length n, time in ns\n");
        System.out.printf("#%s %2s  %2s %2s  %2s\n", "n","selection", "insertion", "insertion_fast", "merge");

        double avg = 0;
     //  int n=1000;

     //   while (n < 17000){
    
        for( int n : sizes) {

            int[] array = keys(n);
            int [] array_1 = keys(n);
            int [] array_2 = keys(n);
            int [] array_3 = keys(n);

            //make a copy of the array;
            for(int i = 0; i < array.length;i++) {

                 array_1[i] = array[i];
                 array_2[i] = array[i];
                 array_3[i] = array[i];
            }
               

            System.out.printf("%d", n);
   
            long t0 = System.nanoTime();
            selectionsort.selsort(array);
            long t1 = System.nanoTime();
            double t_selsort = (t1 - t0);

         //insertion sort

 
            t0 = System.nanoTime();
            MergeF.mergesort(array_1);
            t1 = System.nanoTime();
            double t_merge_f= (t1 - t0);

            t0 = System.nanoTime();
            insertionsort.insersort_fast(array_2);
            t1 = System.nanoTime();
            double t_insersort_f= (t1 - t0);

        //merge sort
        
            t0 = System.nanoTime();
            Merge.mergesort(array_3);
            t1 = System.nanoTime();
            double tmerge= (t1 - t0);

            //double ratio = t_merge_f/tmerge;
            double ratio = t_selsort/t_insersort_f;

            System.out.printf("  %4.0f  %4.0f %4.0f  %4.0f %4.2f\n", t_selsort, t_insersort_f, tmerge, t_merge_f, ratio);

         //    n+=1000;
            avg += tmerge/t_merge_f;

        }

           System.out.println();
           System.out.printf("%.2f",avg/16); 
    }
}        

     /*    int loop = 10;
        int [] arr = {2, 13, 99, 120, 5, 8, 0, 33};

        System.out.println("Selection sort");

        for(int i = 0; i < arr.length; i++) 
            System.out.printf("%4d", arr[i]);

        System.out.println();    
        selectionsort.selsort(arr);

        for(int i = 0; i < arr.length; i++) 
            System.out.printf("%4d", arr[i]);

        System.out.println();     

////////////////////////////////////////////////////////

        System.out.println("Insertion sort");   
        int [] array  = {2, 13, 99, 120, 5, 8, 0, 33};

        for(int i = 0; i < array.length; i++) 
            System.out.printf("%4d", array[i]);
        
        System.out.println();    
        insertionsort.insersort(array);

        for(int i = 0; i < array.length; i++) 
            System.out.printf("%4d", array[i]);   
            
////////////////////////////////////////////////////////        

    }*/


/*
            for(int i = 0; i < array_1.length;i++) 
                System.out.printf("%4d", array_1[i]);   
            System.out.println();
             insertionsort.insersort(array_1);    

              for(int i = 0; i < array_1.length;i++) 
                System.out.printf("%4d", array_1[i]);   
 */