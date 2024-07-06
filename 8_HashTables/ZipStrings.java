import java.io.BufferedReader;
import java.io.FileReader;

public class ZipStrings {

    Node[] data;
    int max;

    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }

    }

    public ZipStrings(String file) { //construtor of main class

        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
        String[] row = line.split(",");
        data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
        }
        
        max = i-1;

    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
    }

    public boolean linear(String zip) {

        for (int i = 0; i <= max; i++) { //nu i < data.length ca e alocat spatiu de 10000!
            if(zip.equals(data[i].code) == true) {
                return true;
            }
        }

        return false;
    }

    public boolean binary(String zip) {
       
        int right = 0; //am incurcat dreapta cu stanga dar nu afecteaza algoritm
        int left = max;
        int mid;

        while (right<=left) {

          mid = (right + left)/2;
        
          if(zip.equals(data[mid].code) == true) {
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