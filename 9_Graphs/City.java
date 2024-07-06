public class City {

    String name;
    Connection [] neighbors;
    int size;

    public City(String name) {
        this.size = 3;
        this.name = name;
        this.neighbors = new Connection [size];
    }

    public void connect(City nxt, int dst) {

      if(neighbors[size - 1] != null) {
            resize();
            neighbors[size/2] = new Connection(nxt, dst);
      }

      else {
            for(int i = 0; i < neighbors.length; i++) {
                if (neighbors[i] == null) {
                    neighbors[i] = new Connection(nxt, dst);
                    return;
                } 
            }
        }
    }

    public void resize() {
        Connection[] tempArray = new Connection[size * 2];

        for (int i = 0; i < neighbors.length; i++)
            tempArray[i] = neighbors[i];

        neighbors = tempArray;
        size = size * 2;
    }

}