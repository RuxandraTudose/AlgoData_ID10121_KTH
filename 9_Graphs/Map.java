import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    private City[] cities;
    private final int mod = 541;
    private int TotalNoCities;
    private int collisions;
    private int i;
    
    public Map(String file) {

        cities = new City[541];
        TotalNoCities = 0;
        i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                i++;
                String[] row = line.split(",");
                City one = lookup(row [0]);
                City two = lookup(row[1]);
               // System.out.println(row[0] + " " + row[1]);    
                Integer distance = Integer.valueOf(row[2]);
                one.connect(two, distance);
                two.connect(one, distance);  
               // System.out.println(one.name + " " + two.name);
                  
            }

        } catch (Exception e) {
            e.printStackTrace();  
          System.out.println(" file " + file + " not found or corrupt");
        }
    
    }

    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }

        return hash % mod;
    }


    public City lookup(String city) {

        Integer hash = hash(city);
        if(cities[hash] == null) {
            cities[hash] = new City(city);
           // System.out.println(hash + " " + city);
            TotalNoCities++;
        }
        else {
            for(int i = hash; i < cities.length; i++) {
                if(cities[i] != null && cities[i].name.compareTo(city) == 0)
                    return cities[i];  
                    
                else if(cities[i] == null) {
                    cities[i] = new City(city);
                    TotalNoCities ++;
                    collisions++;
                        // System.out.println(hash + " " + city);
                    return cities[i];
                }
            }
        }
        
        return cities[hash];
    }


    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        Connection [] city = map.cities[204].neighbors;
        
        System.out.println(map.cities[204].name + ",");
        for(int i = 0; i < city.length ; i++) {
            if(city[i] != null)
                System.out.println(city[i].city.name);

        }

        System.out.print(map.TotalNoCities + "//");
        System.out.println(map.i + "<<");
        
    }    
}
