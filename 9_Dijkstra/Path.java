public class Path implements Comparable<Path> {
    public City city;
    public Integer dist;

    public Path(City city) {
        this.city = city;
        this.dist = 0;
    }
    
    @Override
    public int compareTo(Path other) {
        return this.dist.compareTo(other.dist);
    }
}