import java.util.Random;

public class GenerateArray {

    public static Integer [] randomarray(int n) {
        
        Integer [] array = new Integer[n];
        Random rand = new Random();

        for(int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n*5);
        }

        return array;
    }

    public static Integer [] orderedarray(int n) {

        Integer [] a = new Integer[n];
        for(int i = 0; i < n; i++)
            a[i] = i;

        return a;    
    }
}