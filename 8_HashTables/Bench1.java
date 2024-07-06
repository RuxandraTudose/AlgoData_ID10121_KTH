public class Bench1 {
    public static void main(String[] args) {

        HashTableBucket hbucket = new HashTableBucket("postnummer.csv");
        HashTableClustering hclustering = new HashTableClustering("postnummer.csv");
        double tmin1 = Double.POSITIVE_INFINITY;
        double tmin2 = Double.POSITIVE_INFINITY;

        hbucket.Hash();
        hclustering.Hash();

        for(int i = 0; i < 100000; i++) {

            double timeStartBucket = System.nanoTime();   
            hbucket.lookup(98499);
            double timeStopBucket = System.nanoTime() - timeStartBucket;

            if(timeStopBucket < tmin1)
                tmin1 = timeStopBucket;

            double timeStartCluster = System.nanoTime();   
            hclustering.lookup(98499);
            double timeStopCluster = System.nanoTime() - timeStartCluster;

            if(timeStopBucket < tmin2)
                tmin2 = timeStopCluster;
        }   
        
        System.out.println("Bucket " + tmin1);
        System.out.println("Cluster " + tmin2);
    }    
}