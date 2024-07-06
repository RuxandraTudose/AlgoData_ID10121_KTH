import java.util.Random;

public class Bench {
  
    public static void main(String[] args) { 

        BinTree sortedtree = new BinTree(); //initialize the root 
        BinTree unsortedtree = new BinTree(); //initialize the root 
        int sizes [] = {250, 500, 1000, 2000, 4000, 8000, 16000};
        double timelookup_sorted = 0;
        double timelookup_unsorted = 0;

        System.out.printf("#%s %2s %2s\n", "n","sorted_tree", "unsorted_tree");

        for(int n : sizes) {

            Integer [] randomarray = GenerateArray.randomarray(n);
            Integer [] sortedarray = GenerateArray.orderedarray(n);

            for(int i = 0; i < randomarray.length; i++)
                sortedtree.add(randomarray[i], i);

            for(int i = 0; i < sortedarray.length; i++)
                unsortedtree.add(sortedarray[i], i);    
        
            for(int k = 0; k < 1000; k++ ) {
                double timeStartDouble = System.nanoTime(); 
                sortedtree.lookup(randomarray[n-1]);
                timelookup_sorted += System.nanoTime() - timeStartDouble; 
            }   
              
            for(int k = 0; k < 1000; k++ ) {
                double timeStartDouble = System.nanoTime(); 
                unsortedtree.lookup(sortedarray[n-1]);
                timelookup_unsorted += System.nanoTime() - timeStartDouble; 
            }    

            System.out.printf("%d %4.2f %4.2f\n", n, timelookup_sorted/1000, timelookup_unsorted/1000);
        }
        
         //sortedtree.print();
    }
}    

  /*tree.add(13,4);
        tree.add(20,7);
        tree.add(8,9);
        tree.add(4,1);
        tree.add(7,3);

        System.out.print(tree.lookup(13));
        System.out.println();
        System.out.print(tree.lookup(4));
        System.out.println();
        System.out.print(tree.lookup(7));
        System.out.println();
        System.out.print(tree.lookup(20));
        System.out.println();
        System.out.print(tree.lookup(5));
        System.out.println();
        System.out.print(tree.lookup(1));*/