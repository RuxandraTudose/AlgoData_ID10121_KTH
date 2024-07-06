import java.io.BufferedReader;
import java.io.FileReader;

public class HashTableBucket {

    Node [] data; 
    int max;
    Node [] hash;
   

    public class Node {
        Integer code;
        String name;
        Integer pop;
        Node next;
        
        public Node(Integer code, String name, Integer pop, Node next) {
            this.code = code;
            this.name = name;
            this.pop = pop;
            this.next = null;
        }
    }

    public HashTableBucket(String file) { //construtor of main class

        hash = new Node[31];
        data = new Node [10000];
        for(int i = 0; i < hash.length; i++) {
            hash[i] = new Node(-1," ", -1, null);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));   
            data[i++] = new Node(code, row[1], Integer.valueOf(row[2]),null);
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
        for(int i = 0; i <= max; i++) {
            Integer value = hashvalue(data[i].code);
            if(hash[value].code == -1)
                hash[value] = data[i];
            else {
                Node index = hash[value];
                while(index.next != null)
                    index = index.next;
                Node p = data[i];
                index.next = p;
                p.next = null;
            }     
        }
    }

    public boolean lookup(Integer zip) {
        int value = hashvalue(zip);
        int count = 0;
            if(hash[value].code.equals(zip))
               return true;
            else {
                Node index = hash[value].next;
                while(index != null) {
                    ++count;
                    if(index.code.equals(zip)) {
                        System.out.println(count + "//");
                        return true;
                    }
                       
                    index = index.next;    
                }
            }

        return false;
    }

    public static void main(String[] args) {

        HashTableBucket h = new HashTableBucket("postnummer.csv");
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