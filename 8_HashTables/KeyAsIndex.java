import java.io.BufferedReader;
import java.io.FileReader;

public class KeyAsIndex {

    Node[] data;
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

    public KeyAsIndex(String file) { //construtor of main class

        data = new Node[100000];
        for(int i = 0; i < 100000; i++) //initialise the array
            data[i] = new Node (-1, " ", -1);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));  
            data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
        }
        
        max = i-1;

    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
    }

 
    public boolean lookup(String zip) {

       Integer c = Integer.valueOf(zip.replaceAll("\\s",""));
        if(data[c].code.equals(c))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        KeyAsIndex zipkeys = new KeyAsIndex("postnummer.csv");

        double tmin1 = Double.POSITIVE_INFINITY;
        double tmin2 = Double.POSITIVE_INFINITY;

        for(int i = 0; i < 100000; i++) {

            zipkeys.lookup("111 15");
            double timeStartKeyAsIndexFirst = System.nanoTime();   
            zipkeys.lookup("111 15");
            double timeStopKeyAsIndexFirst = System.nanoTime() - timeStartKeyAsIndexFirst;

            zipkeys.lookup("984 99");        
            double timeStartKeyAsIndexSecond = System.nanoTime();   
            zipkeys.lookup("984 99");
            double timeStopKeyAsIndexSecond = System.nanoTime() - timeStartKeyAsIndexSecond;   

            if(timeStopKeyAsIndexFirst < tmin1)
                tmin1 = timeStopKeyAsIndexFirst;

            if(timeStopKeyAsIndexSecond < tmin2)
                tmin2 = timeStopKeyAsIndexSecond;    
        }

            System.out.println("KeyAsIndex[us]: " + tmin1/1000); //it's converted to an int
            System.out.println("KeyAsIndex[us]: " + tmin2/1000); //it's converted to an int

    }    
}