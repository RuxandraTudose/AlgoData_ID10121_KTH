import java.util.LinkedList;

class LinkedSimple {
 
	public class Node {
		public int number;
		public Node next;

		public Node (int number) {
			this.number = number;
			this.next = null;
		}
	}
    
    public Node first;
    public Node last;

    public void LinkedList () {
        first = null;
        last = null;
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

        return count + 1;
    }

    void push (int a) {

        if(first == null) {
            first = new Node(a);
            return;
        }

        Node index = first;
        while(index.next != null) {
            index = index.next;
        }

        index.next = new Node(a);
        last = index.next;
    }

    /*int pop () throws IllegalArgumentException {
        
        if(this.length() == 0)
            throw new IllegalArgumentException("empty pop"); 
            
        if(this.length() == 1) {
            int no = first.number;
            first = null;
            return no;
        }

        Node index = first;    
        
        while(index.next.next != null) {
            index = index.next;
        }

        int no = index.next.number;
        index.next = null;

        return no;
    }*/

    int[] asArray() {

		int [] array = new int [length()];
		Node index = first;
		for (int i = 0; i < length(); i++) {
			array[i] = index.number;
			index = index.next;
	    }

	    return array;
	}

    int tail() {
        return last.number;
    }


    public void QuickSort() {
        
        if(first.next != null) {
            LinkedSimple small = new LinkedSimple();
            LinkedSimple large = new LinkedSimple();

            Node index = first;
            Node pivot = last;

            while(index.number != pivot.number) {
              if(index.number < pivot.number)
                  small.addNode(index);
              else if (index.number > pivot.number) {
                  large.addNode(index);
                    }   
              index = index.next;     
            }

            if(small.first != null) {
                small.QuickSort();
                first = small.first;
                small.last.next = pivot; //insert pivot
            }

            else 
                first = pivot;

            if(large.first != null) {
                large.QuickSort();
                last = large.last;
                pivot.next = large.first;
            } 
        
            else
                last = pivot;
                last.next = null;

        }

        else return;
    }
    

    public void addNode(Node index) {
        
        if(first == null)
            first = index;
        else
            last.next = index;

        last = index;
    }


    public static void main (String args[]) { //for debugging

        LinkedSimple list = new LinkedSimple();
        list.push(2);
        list.push(25);
        list.push(6);
        list.push(13);
        list.push(3);
        list.push(89); 
        list.push(27);

        list.QuickSort();

        int [] a = list.asArray();

        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println(a.length);

    }    

}    


   
    

