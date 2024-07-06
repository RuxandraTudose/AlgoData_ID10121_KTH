public class Binary {
 
    public static boolean search (int[]array, int key) {

        int min = 0;
        int max = array.length - 1;
        int found = 0;
        int mid;

        while (min<=max && found == 0) {

          mid = (min + max)/2;
        
          if(array[mid] == key) {
            found = 1;
            return true;
          }

          else {
            if(key < array[mid])
                max = mid -1;
            else
                min = mid + 1;    

          }

        }

     if(found == 0) 
            return false;
     else
      return true;      

    }

    public static void better (int [] array, int [] index) {

      int j=-1, i=-1;;
      int count = 0;
      
      while (i < array.length -1 && j < index.length -1) {

        if(index[j+1] < array[i+1]) 
          j++;

        else {
           
          if (index[j+1] == array[i+1]) {
            count++;
        //    System.out.println(index[j+1]);
          }

          i++;
        }
      }
    }

    public static void main (String[] args) {

        int array [] = {2,3,5,25,47,55};
        int arr [] = {1, 7 , 25};
        better(array, arr);
     //  System.out.print("Duplicates: ");
     //  System.out.print(better(array, arr));

     
    }
}