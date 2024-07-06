import java.util.Random;

public class unsorted {

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
             if (array[index] == key) {
                 return true;
             }
        }
        return false;
    }

//generate an unsorted array of keys to look for in an array
    public static int[] keys(int loop, int n) {
        Random rnd = new Random();	
        int[] indx = new int[loop];

        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }	
        return indx;
    }
}


 /*   public static void main (String [] args) {

        int array [] = keys(10, 100);

        for(int i = 0; i< array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    
    } 
}  */  

