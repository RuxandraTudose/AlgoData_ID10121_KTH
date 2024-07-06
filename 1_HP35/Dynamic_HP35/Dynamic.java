public class Dynamic extends ImplementStack {

    int counter;
    int [] dynstack;
   
    //send parameter for dynamic stack for the initial stack
    public Dynamic (int size) {

        this.dynstack = new int [size]; //change size here
        this.counter = -1;
    }

    public void push (int elem) {

        if(counter < dynstack.length - 1)
            dynstack[++counter] = elem;

        else {

            int [] extendstack = new int[dynstack.length + dynstack.length/2];
            
            for(int i=0; i < dynstack.length; i++) {
                extendstack[i] = dynstack[i];
            }

            extendstack[dynstack.length] = elem;
            counter ++;
            dynstack = extendstack;
        }    
        
    /*  System.out.println("ct: " + counter);
        System.out.println("value: " + elem);
        System.out.println("size " +  dynstack.length); */
       
    }

    public int pop () {

        if(counter < dynstack.length/4 && counter!= -1) {
            int [] shrinkstack = new int [dynstack.length/2];
            for(int i = 0; i <= counter; i++) 
                shrinkstack[i] = dynstack[i];
                dynstack = shrinkstack;  
                return dynstack[counter--]; 
        }
        
        if(counter!= -1) 
            return dynstack[counter--];
        else 
            throw new ArrayIndexOutOfBoundsException ("Empty pop");
    }
}    