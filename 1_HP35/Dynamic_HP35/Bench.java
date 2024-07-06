public class Bench {

    //bench for dynamic
    public static void bench (int loop, int ops, Dynamic stack) { //loop how many times to repeat push and pop 
        for (int i = 0; i<loop; i++) {
            for(int k=0;k<ops;k++)
                stack.push(k);

            for(int k = 0; k<ops;k++)
                stack.pop();    
        }
    }

    //bench for static
    public static void bench (int loop, int ops, Stack stack) { //loop how many times to repeat push and pop 
        for (int i = 0; i<loop; i++) {
            for(int k=0;k<ops;k++)
                stack.push(k);

            for(int k = 0; k<ops;k++)
                stack.pop();    
        }
    }

    //measure time in miliseconds for Dynamic
    public static double time(int loop, int tries, int ops, Dynamic stack) {

        double min = Double.POSITIVE_INFINITY;
        
        for(int i=0; i < tries;i++) { //tries shows how many times to run the loops
            
            System.gc(); //suggest garbage collector that it would be nice to clean now
           
            double t0=System.nanoTime(); //start time
            bench(loop,ops,stack);
            double t1 = System.nanoTime(); //end time

            if(t1-t0 < min)
                min = t1-t0;
        }

        return min/1000000;
    }

    //measure time in miliseconds for Static
      public static double time(int loop, int tries, int ops, Stack stack) {

        double min = Double.POSITIVE_INFINITY;
        
        for(int i=0; i<tries;i++) {
           
            System.gc();
           
            double t0=System.nanoTime();
            bench(loop,ops,stack);
            double t1 = System.nanoTime();
           
            if(t1-t0 < min)
                min = t1-t0;
        }

        return min/1000000;
    }

    static void bench (int ops) {
        int tries = 10;
        int loop = 1000;

        Dynamic stat = new Dynamic(ops);
        Stack st = new Stack(ops);
       
        time(loop *10, tries, ops, stat); //operation to activate cache and to avoid misleading time results because of it 

        double dyn_t = time(loop, tries, ops, stat);
        double stat_t = time (loop, tries, ops, st);
        
        System.out.printf("%d \t %.2f\t %.2f\t %.2f\n", ops, (stat_t/loop*1000), (dyn_t/loop*1000), (dyn_t/loop*1000)/(stat_t/loop*1000));

    }

    public static void main (String[] arg) {
        System.out.printf ("#%s\t%s\t%s\t%s\n", "n", "static", "dyn ",  "ratio");
        bench (100);
        bench (300);
        bench (900);
        bench (2700);
        bench (8100);
       // bench (3200);
    }
}

//top<size/4 
//size/2
//System.gc() suggest garbage collecion - to not disturb my process when I measure the time 
//time(loop*10, tries, ops, stat) - warm up the caches
//time from the first push to the last pop
//can also measure them separately
//there are no right answers 
//report everything you notice
//double push, pop operations - dopouble the time - predictable - static
//System.out.ptintln()
//why double the new stack - dyn double vs add fixed number

//adding by a fixed amount expand proportional to the size
//efficient memory usage 

//run time complexity push, pop in static stack - ct - always double 
//dynamic expensive push operation : depends on luck either constant or proportional to the size 
//amortised cost - dynamic push doesn't depend on the size

//time critical - static

//shrinking -  save space - but lose time copying items 
//delay the shrinking as much as possible 

//the call stack
//after retunr I cannot reach the arguments any more - I can reuse that space
//how is memory reclaimed in Java --- garbage collection --- what you use copy to other location (new heap) and reclame the old heap - time proportional to the living data 