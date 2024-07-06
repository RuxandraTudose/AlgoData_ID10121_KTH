import java.util.Random;

public class Bench_2 {
    public static void main(String[] args) {

        double avgdepth = 0;
        double MinPushTime = Double.POSITIVE_INFINITY;
        double MinDepth = Double.POSITIVE_INFINITY;
        double MinAddRemTime = Double.POSITIVE_INFINITY;

        Random rand = new Random();

        int [] numbers = GenerateArray.random(1023, 10000);
        int [] increase = GenerateArray.random(100, 100);
        Heap heap = new Heap();

        for (int i = 0; i < 1023; i++)
            heap.add(numbers[i]);

        for (int k = 0; k < 1000; k++) {

            double timeStartPush = System.nanoTime();    
            for (int i = 0; i < 100; i++) {
                heap.push(increase[i]);
            }    
            double timeStopPush = System.nanoTime() - timeStartPush; 

            if(timeStopPush < MinPushTime)
                MinPushTime = timeStopPush;

            heap.resetHeap();    
            
            for (int i = 0; i < 1023; i++)
                heap.add(numbers[i]);

            for (int i = 0; i < 100; i++) {
                int depth = heap.push(increase[i]);
              //  System.out.println(depth);
                avgdepth += depth;
            }  

            if(avgdepth < MinDepth)
                MinDepth = avgdepth;

        }

        heap.resetHeap();

        for (int i = 0; i < 1023; i++)
            heap.add(numbers[i]);

        for (int k = 0; k < 1000; k++) {

            double timeStartAddRem = System.nanoTime();    
            for (int i = 0; i < 100; i++) {
                int n = heap.remove();
                heap.add(n + increase[i] );
            }    
            double timeStopAddRem = System.nanoTime() - timeStartAddRem; 

            if(timeStopAddRem < MinAddRemTime)
                MinAddRemTime = timeStopAddRem;

        }    
   
        System.out.println("MinDepthPush: " + MinDepth/100);
        System.out.println("MinPushTime: " + MinPushTime/100);
        System.out.println("MinAddTime: " + MinAddRemTime/100);
    }
}        