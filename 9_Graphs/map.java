/*public class Map {
    private []
    private int size
}

//read lines from file
//
i++
string row split
City one = lookup(row [0]);
distamce = integer value of row[2]
one.connecf(two,dist)
two.connect(one, dist)



//integer hash 7 ?
// integer size  = get total no of cities 

public class Map {
private City[] cities;
private final int mod = 541;
public Map(String file) {
cities = new City[mod];
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
String line;
while ((line = br.readLine()) != null) {
:
}
} catch (Exception e) {
System.out.println(" file " + file + " not found or corrupt");
}
}
:
}

public City find (String name) - null if not found
lookup - if null add the city x


public void connect (City next, int dist) {
    if neighbors[i] = null
    create a new connection 
    return;

    //copy the connection array 
}

//naive seacrhing
//read map 
city from map.find(args[0])
city to = map.find (args[1]);
if from == null - not in the map 
Integer dist = shortest(from, to, depth) //set depth how much you want it to be 

public Integer shortest (City from, City to, Integer max)
//map hidden in cities 

max < 0 null
from == to return 0 //check the same obect
Integer shrt = null
i = 0; i < from.neigh.length; i++
check diff than null
Connection conn = from.neigh[i];
integer dist = shortest(conn.city, to, max - conn.dist);
dist != null && shrt == null || shrt > dist + conn.dist);
shrt = dist + conn.dist;
//////////////
public class Paths
City[] path;

int sp = 0 - stack pointer
call shortest - not static 
no max depth
if(path[i] == from)
    retunr null;

path[sp++] = from;   
naive - guess max depth
iterative -- start with a small depth + and increase it step by step */