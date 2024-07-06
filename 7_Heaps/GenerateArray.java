import java.util.Random;

public class GenerateArray {

    public static void swap (int [] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static int [] randomarray(int n) {
        
        Random rand = new Random();
        int [] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = i;

        for(int i = 0; i < n; i++)
            swap(a, i, rand.nextInt(n-1));   
        return a;    
    }

    public static int [] random(int n, int p) {
        Random rand = new Random();
        int [] a = new int [n];
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt(p);

        return a;    
    }

}