import java.util.Random;

class Bench {

    public static void main(String[] args) {  
		int [] sizes = {25, 50, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 52000};

		System.out.printf("#%s %2s %2s %2s\n", "n","time_doubly", "time_simple", "ratio");
  
		for (int n : sizes) {
			LinkedSimple linkedSimple = new LinkedSimple();
			LinkedDouble linkedDouble = new LinkedDouble();
			int [] numbers = generate_array.array(n);

			try {
				linkedSimple.createList(numbers);
				linkedDouble.createList(numbers);
			} catch(Exception e) {
				System.out.println(e);
			}
              
			Random rand = new Random();
			double timeDouble = 0;
			double timeSimple = 0;
             
			for (int i = 0; i < 1000; i++) {				 
                int index = rand.nextInt(n-1);
				
              
				LinkedDouble.Node randomNodeDouble = linkedDouble.getNode(index);
				double timeStartDouble = System.nanoTime();
				
                linkedDouble.unlink(randomNodeDouble);
                linkedDouble.insert(randomNodeDouble);
                timeDouble += (System.nanoTime() - timeStartDouble);
             
				LinkedSimple.Node randomNode = linkedSimple.getNode(index);
				double timeStartSimple = System.nanoTime();
                linkedSimple.unlink(randomNode);
				linkedSimple.insert(randomNode);
                timeSimple += (System.nanoTime() - timeStartSimple);
            }    
             
			System.out.printf("%d   %4.0f   %4.0f  %4.2f\n", n, timeDouble/1000, timeSimple/1000, timeSimple/timeDouble);
                          
		}  
            
    }
  
      
}

