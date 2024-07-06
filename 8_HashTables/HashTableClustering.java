import java.io.BufferedReader;
import java.io.FileReader;

public class HashTableClustering {

    Node [] data; 
    int max, size;
    Node [] hash;
   

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

    public HashTableClustering(String file) { //construtor of main class

        size = 31;
        hash = new Node[size];
        data = new Node [10000];
        for(int i = 0; i < hash.length; i++) {
            hash[i] = new Node(-1," ", -1);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));   
            data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
        }
        
        max = i-1;

    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
    }

    public Integer hashvalue(Integer n) {
        return n % 31;
    }

    public void Hash() {
        int j = 0;
        for(int i = 0; i <= max; i++) {
            if(j == size) {
                resize();
                j = 0;
            }
            Integer value = hashvalue(data[i].code);
            if(hash[value].code == -1)
                hash[value] = data[i];
            else {
                while(hash[value++].code != -1) {
                    if(value == size) {
                        resize();
                        j = 0;
                    }
                    
                }
                hash[value - 1] = data[i];
            }  
            j++;
        }
    }

    public boolean lookup(Integer zip) {
        int count = 0;
        int value = hashvalue(zip);
        while(hash[value].code != -1) { 
            ++count;
            if(hash[value].code.equals(zip)){
                System.out.println(count + "//");
                return true;
            }

            value++;
        }  
        return false;
    }

    public void resize() {
        Node [] tempArray = new Node [size * 2];

        for(int i = 0; i < tempArray.length; i++) {
            tempArray[i] = new Node(-1," ", -1);
        }

        for (int i = 0; i < hash.length; i++)
            tempArray[i] = hash[i];

        hash = tempArray;
        size = size * 2;
    }

    public static void main(String[] args) {

        HashTableClustering h = new HashTableClustering("postnummer.csv");
        h.Hash();
        System.out.println(h.lookup(98499));
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
//Java - over the bound on ints - return negative value - use floor function
//cryptographic hash functions - unlikely for the digest to be the same and not belong to similar documents 

//"SHA3-256"
//Sha - Secure Hash Algorithms