public class Bench {

    public static void main (String args[]) {

        int [] sizes = {25, 50, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400, 204800, 409600};
		System.out.printf("#%s %2s %2s\n", "n","time_array", "time_linked list");  

        double avg = 0;
        
        for (int n : sizes) {

			LinkedSimple linkedlist= new LinkedSimple();
			QuickSortArray a = new QuickSortArray(n);
            int [] numbers = GenerateArray.randomarray(n);

            for(int i = 0; i < numbers.length; i++)
                linkedlist.push(numbers[i]);

            for (int i = 0; i < numbers.length; i++) 
                a.array[i] = numbers[i]; 

           /*  linkedlist.QuickSort();
            linkedlist.first = null;  
            numbers = GenerateArray.randomarray(n);  

            for(int i = 0; i < numbers.length; i++)
                linkedlist.push(numbers[i]);

            for (int i = 0; i < numbers.length; i++) 
                a.array[i] = numbers[i]; */
  
            double timeStartLinked = System.nanoTime();
            linkedlist.QuickSort();
            double timeStopLinked = System.nanoTime() - timeStartLinked;  

            /*int [] arr = linkedlist.asArray();
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();*/
            
           /*  linkedlist.first = null;  
            numbers = GenerateArray.randomarray(n);
            for(int i = 0; i < numbers.length; i++)
                linkedlist.push(numbers[i]); */

            double timeStartArray = System.nanoTime();
            a.sort(a.array, 0, a.array.length - 1);
            double timeStopArray = System.nanoTime() - timeStartArray; 
            
            System.out.printf("%d   %4.0f  % 4.0f  %4.2f\n", n, timeStopArray/1000, timeStopLinked/1000, (timeStopLinked/1000)/(timeStopArray/1000)); //, timeStopArray/timeStopLinked);
            avg += (timeStopLinked/1000)/(timeStopArray/1000);
            //System.gc();
        }

        System.out.println("average: " + avg/15);
    }    
}
