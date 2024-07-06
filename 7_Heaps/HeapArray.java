public class HeapArray {

    public int[] array;
    int first;
    int last;
    int size;

    public HeapArray() {
        size = 4;
        array = new int[4];
        last = -1;
        first = 0;
    }

    public void resize() {
        int[] tempArray = new int[size * 2];

        for (int i = 0; i < array.length; i++)
            tempArray[i] = array[i];

        array = tempArray;
        size = size * 2;
    }

    public Integer remove() {
        if (last == 0) {
            last = -1;
            return array[0];
        }
          
        if(last != -1) {
        int value = array[0];
        array[0] = array[last]; // Replace the root with the last element
    
        int i = 0;
        while (i * 2 + 1 < last) { //check not to go outbounds
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
    
            int minChild = leftChild; //assume left is minimum - all numbers under it are greater than it
    
            if (rightChild < last && array[rightChild] < array[leftChild]) {
                minChild = rightChild;
            }
    
            if (array[i] > array[minChild]) {
                // Swap parent with the smaller child
                int temp = array[i];
                array[i] = array[minChild];
                array[minChild] = temp;
            } else {
                 return -1;   
            }
    
            i = minChild;
        }
    
        last--;
        size--;
    
        return value;
        } 

        else return -1;
    }

    public void resetArrHeap(){
        size = 4;
        array = new int[4];
        last = -1;
        first = 0;
    }

    public void add(int item) {

        if (last + 1 == size)
            resize();

        array[++last] = item;

        int i = last;
        while (i > -1) {
            int j = (i - 1) / 2; //floor function to get the parent

            if (array[i] >= array[j])
                return;

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i = j;
        }
    }

    public int [] asArray() {
        int a [] = new int[array.length];
        for (int i = 0; i <= last; i++)
            System.out.print(array[i] + " ");

        for (int i = 0; i <= last; i++)    
            a[i] = array[i];

        return a;     
    }

    public static void main(String[] args) {

        HeapArray array = new HeapArray();
        array.add(8);
        array.add(7);
        array.add(10);

        //System.out.println();
       // array.asArray();

        System.out.println( array.remove() + "/");
       
       // array.asArray();
        System.out.println(array.remove() + "/");
        
       // array.asArray();
        System.out.println(array.remove() + "/");
    
       // array.asArray();
        System.out.println(array.remove() + "/");
        System.out.println(array.remove() + "/");

     
        int [] a = array.asArray();
        System.out.print(a.length + "/");
    }
}