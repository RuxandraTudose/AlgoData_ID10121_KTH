public class LinkedPriorQueueUnsorted {

 Node head;
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }    
    }

    public LinkedPriorQueueUnsorted() {
         head = null;
    }

    public void add(Integer item) {

        if(head == null) {
            head = new Node (item, null);
            return;
        }

        Node n = new Node (item, null);
        n.next = head;
        head = n;
    }

    public Integer remove() {

        if(head == null)
            return null;

        if (head.next == null ){
            int d = head.item;
            head = null; 
            return d;
        }  

        Node remove = null;
        Node neighbour_remove = null;
        
        Node index = head;
        Node previous = null;
        int c = index.item;
        while(index != null) {
                
            if(index.item < c) {
                c = index.item;
                remove = index;
                neighbour_remove = previous;
            }
                
            previous = index;
            index = index.next;    
              
        }

        if(c == head.item) {
            head = head.next;
            return c;
        }
     
        neighbour_remove.next = remove.next;
        return c;
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

    public int [] asArray() {
        
        Node index = head;
        int [] a = new int [length()];
        
        for(int i = 0; i < a.length; i++) {
            a[i] = index.item;
            index = index.next;
        }

        return a;
    }

    public static void main(String[] args) {
        LinkedPriorQueueUnsorted q = new LinkedPriorQueueUnsorted();
      
        q.add(7);
        q.add(12);
        q.add(3);
        q.add(13);
        q.add(8);

      
        int [] b = q.asArray();
        System.out.println(b.length);
        
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");

        System.out.println();   
        System.out.println("//////");    
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
       
    }

       
}    