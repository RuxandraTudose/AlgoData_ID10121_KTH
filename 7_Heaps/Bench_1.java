public class Bench_1 {
    public static void main(String[] args){

        int [] sizes = {100, 200, 400, 800, 1600, 3200,6400, 12800, 25600, 51200};
        System.out.printf("#%s %2s %2s\n", "n","SortedPriorityQueue", "UnsortedPriorityQueue");  
        double avg = 0;
        
        for (int n : sizes) {

            LinkedPriorQueueSorted pqs = new LinkedPriorQueueSorted();
            LinkedPriorQueueUnsorted pqu = new LinkedPriorQueueUnsorted();
            HeapArray heaparr = new HeapArray();

            double MinTimepqs = Double.POSITIVE_INFINITY;
            double MinTimepqu = Double.POSITIVE_INFINITY;
            double MinTimeArr = Double.POSITIVE_INFINITY;
            int [] increase =  GenerateArray.randomarray(n);

            for(int i = 0; i < n; i++) {
                pqs.add(i);
            }

            for(int i = 0; i < n; i++) {
                pqs.remove();
            }

            for(int i = 0; i < n; i++) {
                pqs.add(i);
            }

            int c = 0;

            for(int i = 0; i < 1000; i++) {

                int index = (c++) % n;
                double timeStartSorted = System.nanoTime();
                int p = pqs.remove();
                pqs.add(p + increase[index]);
                double timeStopSorted = System.nanoTime() - timeStartSorted; 
              
                if(timeStopSorted <  MinTimepqs)
                    MinTimepqs = timeStopSorted;
            }

            //warm-up
            for(int i = 0; i < n; i++) {
                pqu.add(i);
            }

            for(int i = 0; i < n; i++) {
                pqu.remove();
            }

            for(int i = 0; i < n; i++) {
                pqu.add(i);
            }
            
            //begin timing
            c = 0; //reset the index
            for(int i = 0; i < 1000; i++) {

                int index = (c++) % n;
                double timeStartUnsorted = System.nanoTime();
                int p = pqu.remove();
                pqu.add(p + increase[index]);
                double timeStopUnsorted = System.nanoTime() - timeStartUnsorted; 
              
                if(timeStopUnsorted <  MinTimepqu)
                    MinTimepqu = timeStopUnsorted;
            }

            //warm-up
            for(int i = 0; i < n; i++)
                heaparr.add(i);

            for(int i = 0; i < n; i++) {
               heaparr.remove();
            }    

            heaparr.resetArrHeap();

            for(int i = 0; i < n; i++)
                heaparr.add(i);

            c = 0;
            for(int i = 0; i < 1000; i++) {

                int index = (c++) % n;
                double timeStartArr = System.nanoTime();
                int p = heaparr.remove();
                heaparr.add(p + increase[index]);
                double timeStopArr = System.nanoTime() - timeStartArr; 
              
                if(timeStopArr <  MinTimepqu)
                    MinTimeArr = timeStopArr;
            }    
        
            System.out.printf("%d   %4.0f  % 4.0f   %4.0f\n", n, MinTimepqs, MinTimepqu, MinTimeArr);
           // avg += MinTimepqs/MinTimepqu;

        }    

           // System.out.printf("%4.2f", avg/7);
    }    

}

//4 benchmarks 
//linked list - array list - linked heap - array heap
//100 - 1600
//measure the time of doing dequeue enqueues 
//do a thousand loops and measure the time 
//first dequeue + incr => [then enqueue +20] NO 
//increment == an array of random ints up until n 
/*for int j = 0; j< inr[length; j++]
    dequeue 
    engueue + incr[j] */
//warm up : just enqueue
//use a clear method 
//double with the size     
//math.floormod(prv-1, queue.length) - for negative numbers
//clear method to have the same situation
//array - lose time copying
//linked heap - logarithmic


