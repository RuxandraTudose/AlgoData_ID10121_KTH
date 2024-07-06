import java.io.BufferedReader;
import java.io.FileReader;

public class ZipInts {

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

    public ZipInts(String file) { //construtor of main class

        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));  
            //System.out.print(code + " ");      
            data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
        }
        
        max = i-1;

    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
    }

    public boolean linear(Integer zip) {

        for (int i = 0; i <= max; i++) { //nu i < data.length ca e alocat spatiu de 10000!
            if(zip.equals(data[i].code)) {
                return true;
            }
        }

        return false;
    }

    public boolean binary(Integer zip) {
       
        int right = 0;
        int left = max;
        int mid;

        while (right<=left) {

          mid = (right + left)/2;
        
          if(zip.equals(data[mid].code)) {
            return true;
          }
          else {
            if(zip.compareTo(data[mid].code) < 0)
                left = mid-1;
            else
                right = mid + 1;    
          }
        }
        
        return false;
    }

}