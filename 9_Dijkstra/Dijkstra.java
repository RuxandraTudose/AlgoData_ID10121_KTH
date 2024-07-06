import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    private List<City> visited;
    private PriorityQueue<Path> queue;
    private Map map;

    public Dijkstra(Map map) {
        this.map = map;
        queue = new PriorityQueue<>();
        visited = new ArrayList<>();
    }

    public void dijkstra(City city_stop) {
        while (!queue.isEmpty()) {
            Path current = queue.remove();
            String name = current.city.name;
            City cityObj = map.lookup(name);
           
            if (visited.contains(cityObj)) {
                continue;
            }

            visited.add(cityObj);

            if (cityObj.name.equals(city_stop.name)) {
                System.out.println(city_stop.name + ": " + current.dist + " min");
                return;
            }

            for (int i = 0; i < cityObj.neighbors.length; i++) {
                if (cityObj.neighbors[i] != null) {

                    City neighborCity = cityObj.neighbors[i].city;
                    Path addcity = new Path(neighborCity);
                    addcity.dist = current.dist + cityObj.neighbors[i].distance;
                  //  System.out.println(neighborCity.name + " distance: " + addcity.dist);
                    queue.add(addcity);
                }
            }
        }
    }

    public void begin(String start, String stop) {
        City city_start = map.lookup(start);
        City city_stop = map.lookup(stop);
        Path p = new Path(city_start);
        queue.add(p);
        dijkstra(city_stop);
    }

    public static void main(String[] args) {
        Map map = new Map("europe.csv");
        Dijkstra dij = new Dijkstra(map);

        long t0 = System.nanoTime();
        dij.begin("London", "Stockholm");
        long time = (System.nanoTime() - t0)/1000000;
        System.out.println("execution time[ns]: " + time);
        System.out.println(dij.visited.size());
    }
}