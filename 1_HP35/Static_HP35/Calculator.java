public class Calculator {
    
    Item [] expr; //Item type 
    int ip; //the array pointer
    Stack stack;
    int size;

    public Calculator (Item [] expr) { //constructor
        
        this.expr = expr;
        this.ip = 0; //start at position zero
        this.stack = new Stack(32);
    }

    public int run () {
        
        while (ip < expr.length) {
                step();
            }
        
        return stack.pop(); //return the final result of the RPN notation
    }

    public void step() {

        Item nxt = expr[ip++]; 

        switch(nxt.type()) {

            case ADD: 
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x+y);
                break;
            
            case SUB: 
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
                break;

            case MUL:
               int c = stack.pop();
               int d = stack.pop();
               stack.push(c*d);
               break;

            case DIV:
               int z = stack.pop();
               int w = stack.pop();
               stack.push(w/z);
               break;

            case VALUE:
               stack.push(nxt.value());
               break;
        }
    }

}