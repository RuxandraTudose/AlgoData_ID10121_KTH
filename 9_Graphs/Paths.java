public class Paths{

    City[] path;
    int sp;

    public Paths() {
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to) {      
        if (from == to)
            return 0;

        for (int j = 0; j < sp; j++) {
            if (path[j] == from)
                return null;
        }    

        path[sp++] = from;
        
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {

            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer dist = shortest(conn.city, to);
                if(dist != null && (shrt == null || shrt > dist + conn.distance))
                    shrt = dist + conn.distance;
            }
        }

        path[sp--] = null;
        return shrt;
    }    

    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        String from = args[0];
        String to = args[1];
        Paths path = new Paths();

        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to));
        long time = (System.nanoTime() - t0)/1_000_000;;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}