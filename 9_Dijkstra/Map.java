import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    private City[] cities;
    private final int mod = 541;
    public int TotalNoCities;
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
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer distance = Integer.valueOf(row[2]);
                one.connect(two, distance);
                two.connect(one, distance);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" file " + file + " not found or corrupt");
        }

    }

    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }

        return hash % mod;
    }

    public City lookup(String city) {

        Integer hash = hash(city);
        if (cities[hash] == null) {
            cities[hash] = new City(city);
            TotalNoCities++;
        } else {
            for (int i = hash; i < cities.length; i++) {
                if (cities[i] != null && cities[i].name.compareTo(city) == 0)
                    return cities[i];

                else if (cities[i] == null) {
                    cities[i] = new City(city);
                    TotalNoCities++;
                    collisions++;
                    return cities[i];
                }
            }
        }
        return cities[hash];
    }
}