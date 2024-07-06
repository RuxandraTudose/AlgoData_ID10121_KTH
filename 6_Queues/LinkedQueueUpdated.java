public class LinkedQueueUpdated <K> {

    Node head;
    Node last; //new

    private class Node {
        K item;
        Node next;

        private Node(K item, Node list) {
            this.item = item;
            this.next = list;
        }    
    }

    public LinkedQueueUpdated() {
         head = null;
    }

    public void add(K item) {

        if(head == null) {
            head = new Node(item, null);
            last = head; //new
            return;
        }

        Node n = new Node(item, null); //new 
        last.next = n; //new
        last = n; //new
    }

    public K remove() {

        if(head == null) {
            return null;
        }
           
        Node index = head.next;
        K n = head.item;
        head = index;
        return n;

        /*first.item
        first = first.next
        if(first = null)
        last = null; */
    }

    public int length () {
        
        Node index = head;
        int count = 0;

        while(index != null) {
            count ++;
            index = index.next;
        }

        return count;
    }

   /* public int [] asArray() {

        if(length() != 0) {

            Node index = head;
            int [] a = new int [length()];
        
            for(int i = 0; i < a.length; i++) {
                a[i] = index.item;
                index = index.next;
            }

            return a;  
        }
        
        return null;
    }*/


}        

