public class Stack extends ImplementStack {
    
    private int size;
    int [] stack;
    int top;


    public Stack (int size) {
        
        this.size = size;
        this.stack = new int [size];
        this.top = -1;
    }

    
    public void push (int value) {
        
        if(top < size -1) {
            stack [++top] = value;
          /*System.out.println("top: " + top);
            System.out.println("value: " + value); */
        }

        else 
            throw new ArrayIndexOutOfBoundsException ("Stack is full");
    }

    public int pop () {

        if(top != -1) 
            return stack[top--];    //by doing top-- the value is deleted from the stack - also by overlapping
        else 
           throw new ArrayIndexOutOfBoundsException ("Empty pop"); 
        
    }
    
}




/*public class Bench {
    public static void bench(int loop, )
}*/