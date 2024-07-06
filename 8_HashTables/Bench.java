public class Bench {

    public static void main(String[] args) {
        ZipStrings zipstring = new ZipStrings("postnummer.csv");
        ZipInts zipints = new ZipInts("postnummer.csv");
        KeyAsIndex zipkeys = new KeyAsIndex("postnummer.csv");


        double tmin1 = Double.POSITIVE_INFINITY;
        double tmin2 = Double.POSITIVE_INFINITY;
        double tmin3 = Double.POSITIVE_INFINITY;
        double tmin4 = Double.POSITIVE_INFINITY;
        double tmin5 = Double.POSITIVE_INFINITY;
        double tmin6 = Double.POSITIVE_INFINITY;
        double tmin7 = Double.POSITIVE_INFINITY;
        double tmin8 = Double.POSITIVE_INFINITY;
        double tmin9 = Double.POSITIVE_INFINITY;
        double tmin10 = Double.POSITIVE_INFINITY;

        for(int i = 0; i < 100000; i++) {
        
        zipstring.linear("111 15");    
        double timeStartLinearFirst = System.nanoTime();   
        zipstring.linear("111 15");
        double timeStopLinearFirst = System.nanoTime() - timeStartLinearFirst;
        if(timeStopLinearFirst < tmin1)
            tmin1 = timeStopLinearFirst;

        zipstring.binary("111 15");
        double timeStartBinaryFirst = System.nanoTime();   
        zipstring.binary("111 15");
        double timeStopBinaryFirst = System.nanoTime() - timeStartBinaryFirst;
        if(timeStopBinaryFirst < tmin2)
            tmin2 = timeStopBinaryFirst;
        
        zipints.linear(11115);
        double timeStartLinearFirstInt = System.nanoTime();   
        zipints.linear(11115);
        double timeStopLinearFirstInt = System.nanoTime() - timeStartLinearFirstInt;
        if(timeStopLinearFirstInt < tmin3)
            tmin3 = timeStopLinearFirstInt;
        
        zipints.binary(11115);
        double timeStartBinaryFirstInt = System.nanoTime();   
        zipints.binary(11115);
        double timeStopBinaryFirstInt = System.nanoTime() - timeStartBinaryFirstInt;
        if(timeStopBinaryFirstInt < tmin4)
            tmin4 = timeStopBinaryFirstInt;

      

        zipstring.linear("984 99");
        double timeStartLinearSecond = System.nanoTime();   
        zipstring.linear("984 99");
        double timeStopLinearSecond = System.nanoTime() - timeStartLinearSecond;
        if(timeStopLinearSecond < tmin6)
            tmin6 = timeStopLinearSecond;

        zipstring.binary("984 99");
        double timeStartBinarySecond = System.nanoTime();   
        zipstring.binary("984 99");
        double timeStopBinarySecond = System.nanoTime() - timeStartBinarySecond;
        if(timeStopBinarySecond < tmin7)
            tmin7 = timeStopBinarySecond;

        zipints.linear(98499);    
        double timeStartLinearSecondInt = System.nanoTime();   
        zipints.linear(98499);
        double timeStopLinearSecondInt = System.nanoTime() - timeStartLinearSecondInt;
        if(timeStopLinearSecondInt < tmin8)
            tmin8 = timeStopLinearSecondInt;
        
        zipints.binary(98499);    
        double timeStartBinarySecondInt = System.nanoTime();   
        zipints.binary(98499);
        double timeStopBinarySecondInt = System.nanoTime() - timeStartBinarySecondInt;
        if(timeStopBinarySecondInt < tmin9)
            tmin9 = timeStopBinarySecondInt;

        
        zipkeys.lookup("111 15");
        double timeStartKeyAsIndexFirst = System.nanoTime();   
        zipkeys.lookup("111 15");
        double timeStopKeyAsIndexFirst = System.nanoTime() - timeStartKeyAsIndexFirst;
        if(timeStopKeyAsIndexFirst < tmin5)
            tmin5 = timeStopKeyAsIndexFirst;

        zipkeys.lookup("984 99");
        double timeStartKeyAsIndexSecond = System.nanoTime();   
        zipkeys.lookup("984 99");
        double timeStopKeyAsIndexSecond = System.nanoTime() - timeStartKeyAsIndexSecond;   
        if(timeStopKeyAsIndexSecond < tmin10)
            tmin10 = timeStopKeyAsIndexSecond;

        }

        System.out.println("111 15");
        System.out.println("Linear search[ns]: " + tmin1);
        System.out.println("Binary search[ns]: " + tmin2);

        System.out.println();

        System.out.println(11115);
        System.out.println("Linear search[ns]: " + tmin3);
        System.out.println("Binary search[ns]: " + tmin4);
        System.out.println("KeyAsIndex[ns]: " + tmin5); //it's converted to an int

        System.out.println("984 99");
        System.out.println("Linear search[ns]: " + tmin6);
        System.out.println("Binary search[ns]: " + tmin7);

        System.out.println();

        System.out.println(98499);
        System.out.println("Linear search[ns]: " + tmin8);
        System.out.println("Binary search[ns]: " + tmin9);
        System.out.println("KeyAsIndex[ns]: " + tmin10); //it's converted to an int
    }    
}
