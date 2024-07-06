class mainclass {

    public static void gurka ()  {
    
// 10 + 2 * 5
// 10 2 5 * + in reversed Polish notation
      
         Item[] expr = {
             
        /*     Item.Value(1),
            Item.Value(2),
            Item.Value(3),
            Item.Value(4),
            Item.Value(5),
            Item.Value(6),
            Item.Value(7),
            Item.Value(8),
            Item.Value(9),
            Item.Value(10),
            Item.Value(11),
            Item.Value(12),
            Item.Value(13),
            Item.Value(14),
            Item.Value(15),
            Item.Value(16),

            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add() */

            Item.Value(10),
            Item.Value(2),
            Item.Value(5),
            Item.Mul(),
            Item.Add() 

        }; 

        long t0 = System.nanoTime();
        long t1 = System.nanoTime();
        System.out.println(" nothing " + (t1 - t0) + " nanoseconds"); 

        double min = Double.POSITIVE_INFINITY;
        int res = 0;

        for(int i = 0; i < 1000; i++) {

            long n0 = System.nanoTime();
       
            Calculator calc = new Calculator(expr);
            res = calc.run(); //final result of the expression stored here
            long n1 = System.nanoTime();

            if(n1-n0 < min)
                min = n1-n0; 
        }

        
        System.out.println(" Calculator: res = " + res);  
        System.out.println(" min resolution static " + min + " nanoseconds");
    }
  

    public static void main  (String[] args) {
        gurka();
    } 

}   
