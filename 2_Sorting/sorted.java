import java.util.Random;

public class sorted {

    public  static int[] sortedarray(int n) {
      
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;

        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }

        return array;
    }


    public static boolean search_sorted(int[] array, int key) { 
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }

            if(array[index] > key) { //sorted array  -  get better performance in some cases only :D
                return false;
            }
        }
        return false;
    }
}