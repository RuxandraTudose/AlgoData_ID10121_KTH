public class generate_array{

    public static int [] array (int n) {
        
        int [] a = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = i;

        return a;    
    }


}