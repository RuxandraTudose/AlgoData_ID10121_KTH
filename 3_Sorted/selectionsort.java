public class selectionsort {

    public static void swap (int [] array, int i, int j) {

        int aux = array[i];
        array[i] = array[j];
        array [j] = aux;
    }

    public static void selsort (int [] array) {

        for (int i = 0; i < array.length; i++) {

            int candidate = i; //the index of the presumed possible min value
            for (int j = i; j < array.length ; j++) {
                if(array[j] < array[candidate]) {
                    candidate = j;
                }
            }
            if(candidate != i)
                swap(array, i, candidate);
        }
    }
}

//increase array sizes