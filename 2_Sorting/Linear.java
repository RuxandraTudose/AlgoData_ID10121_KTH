public class Linear { //better linear search algorithm 

    public static boolean search(int[] array, int key) { 
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }

           if(array[index] > key) { //sorted array  -  get better performance 
               return false;
            }
        }
        return false;
    }
}

