import java.io.BufferedReader;
import java.io.FileReader;

public class HashTableCollisions {

    Node [] data; 
    Integer[] keys;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }

    }

    public HashTableCollisions(String file) { //construtor of main class

        keys = new Integer[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));   
          //  data[i] = new Node(code, row[1], Integer.valueOf(row[2]));
            keys[i++] = code;
        }
        
        max = i-1;

    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
    }

    public void collisions(int mod) {
       
        int[] data = new int[mod];
        int[] cols = new int[10];
       
        for (int i = 0; i <= max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }

        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }

        System.out.println();
    }
    

    public static void main(String[] args) {

        HashTableCollisions h = new HashTableCollisions("postnummer.csv");
        int [] collisions = {10000, 20000, 12345, 13513, 13600, 14000};
        for(int n : collisions) 
            h.collisions(n);
         
    }    
}




//hash range much smaller
//key - h(key)
//hash a string - make each character count a bit 
/*int R = 31;
public static Integer hash ( String key , int M ) {
char [] chars = key . toCharArray ();
int value = 0;
for (int i = 0; i < chars . length ; i ++) {
    value = ( R * value + chars [ i ]) % M ;
}
return value ;
}*/

//hashCode() function for strings objects - might give strange negative value 