import java.util.Random;

public class estimation {

    public static void main (String [] args) {

        int n = 64000000;
        int array [] = sorted.sortedarray(n);

        Random rnd = new Random();	
     
        int loops = 1000;
        int tries = 10;
        int key = rnd.nextInt(n);
        Bench.time(array, loops, tries, key);
        double t = Bench.time(array, loops, tries, key);
        
        System.out.printf("%s\t %s\n", "#n", "ratio");
        System.out.printf("%d %8.8f", n, t/n);

    }


}