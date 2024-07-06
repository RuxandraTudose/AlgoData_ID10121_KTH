import java.util.LinkedList;

class LinkedSimple <K>{
 
	public class Node {
		public K number;
		public Node next;

		public Node (K number) {
			this.number = number;
			this.next = null;
		}
	}
    
    public Node first;

    public void LinkedList () {
        first = null;
    }

    int length () {

        if(first == null)
            return 0;
        
        Node index = first;
        int count = 0;

        while(index.next!= null) {
            count ++;
            index = index.next;
        }

        return count;
    }

    void push (K a) {

        if(first == null) {
            first = new Node(a);
        }

        Node index = first;
        while(index.next != null) {
            index = index.next;
        }

        index.next = new Node(a);
    }

    K pop () throws IllegalArgumentException {
        
        if(this.length() == 0)
            throw new IllegalArgumentException("empty pop"); 
            
        if(this.length() == 1) {
            K no = first.number;
            first = null;
            return no;
        }

        Node index = first;    
        
        while(index.next.next != null) {
            index = index.next;
        }

        K no = index.next.number;
        index.next = null;

        return no;
    }

}    


   
    

