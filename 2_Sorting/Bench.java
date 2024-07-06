import java.util.Random;

public class Bench {

//generate random unsorted array     

/*private static int[] unsorted(int n) {
       
    Random rnd = new Random();	
    int[] array = new int[n];
    int nxt = rnd.nextInt(10);

    for (int i = 0; i < n ; i++) {
        array[i] = nxt;
        nxt = rnd.nextInt(n*500000);
    }	
    return array;
}*/

private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Linear.search(array, indx[i]);
        }
    }
    

    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Binary.search(array, indx[i]);
        }
    }


    public static double time (int array[], int loops, int tries, int key) {

        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < tries; i++) {
            
            double t0 = System.nanoTime();
            for (int j = 0; j < loops; j++) {
                Binary.search(array, key);
            }

            double t1 = System.nanoTime();

            if(t1-t0 < min)
                min = t1-t0;
        }
        
       return min/loops;
    }


    public static double timelin(int array[], int loops, int tries, int key) {

        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < tries; i++) {
            
            double t0 = System.nanoTime();
            for (int j = 0; j < loops; j++) {
                Linear.search(array, key);
            }

            double t1 = System.nanoTime();

            if(t1-t0 < min)
                min = t1-t0;
        }
        
       return min/loops;
    }

    public static void main(String[] arg) {

        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600, 1000000};
        double avg =0 ;
    
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%s%8s%8s%8s%8s\n", "n","linear", "binary", "better", "bin/imp");

        for ( int n : sizes) {
    
            int loop = 10000;
            
            int[] array = sorted.sortedarray(n);
            int [] arr = sorted.sortedarray(n);
            int[] indx = unsorted.keys(loop, n);
    
            System.out.printf("%d", n);
    
            int k = 1000;  
    
            //linear search in a sorted array
          /*   double min = Double.POSITIVE_INFINITY;
    
            for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            linear(array, indx);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
            }
    
            System.out.printf("%8.0f", (min/loop));*/	    
    
            //binary serch for keys - one sorted array 
            double min = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < k; i++) {
               
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);

                if (t < min)
                    min = t;
            }
            
            double tbin = min/loop;
            System.out.printf("%8.0f" , (min/loop));	

            //improved alg in PDF

            min = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < k; i++) {
               
                long t0 = System.nanoTime();
                Binary.better(array, arr);
                long t1 = System.nanoTime();
                double t = (t1 - t0);

                if (t < min)
                    min = t;
            }
            
            double t_imp = min/loop;
            avg += tbin/t_imp;
            System.out.printf("%14.3f" , (min/loop));	
            System.out.printf("%14.3f\n" , (tbin/t_imp));



        }
       System.out.println(avg/16);
    }
    }




   /* public static void main (String [] args) {

    int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};
    double avg =  0;
   
       Random rnd = new Random();	
     
       int loops = 1000;
       int tries = 10;

       int key_cache = rnd.nextInt(100*10000);
       int array_cache [] = sorted.sortedarray(100);
       time (array_cache, loops, tries, key_cache);

       System.out.printf("%s\t %s %s  %s %s %s\n","#n", "ns/binsr", "ns/linsr", "linear/bin_ratio", "bratio", "linratio");
       System.out.println();
      //int n= 64000000;
    //  for(int i = 0; i < 5; i++) {

           for(int n:sizes) {
            
                int key = rnd.nextInt(n);
                int array [] = sorted.sortedarray(n);
                //double t = time (array, loops, tries, key);
                double tbin = time (array, loops, tries, key);
                double tlin = timelin (array, loops, tries, key);

                double ratio = (tlin/n)/(tbin/n);

                System.out.printf("%d %8.0f %8.0f %8.4f  %8.4f %8.4f\n ", n, tbin, tlin, ratio, tbin/n, tlin/n); //tbin/n to get the multiplication coefficient for the estimation
                avg += ratio ;
              //System.out.printf("%8d %8.0f %8.8f\n ", n, t, t/n);
              if(n>300)
                avg+=tbin;

            }
   //   }

     System.out.printf("%s", "ratio on average : "); 
     System.out.printf("%.8f", avg/16);
       
    }
}*/
