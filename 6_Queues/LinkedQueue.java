public class LinkedQueue {
    Node head;
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }    
    }

    public LinkedQueue() {
         head = null;
    }

    public void add(Integer item) {

        if(head == null) {
            head = new Node (item, null);
            return;
        }

        Node index = head;
        while(index.next != null) {
            index = index.next;
        }
        
        index.next = new Node(item, null); 
    }

    public Integer remove() {

        if(head == null)
            return null;
 
        Node index = head.next;
        int n = head.item;
        head = index;
        return n;
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

        LinkedQueue queue = new LinkedQueue();
        queue.add(5); 
        queue.add(7); 
        queue.add(20); 
        queue.add(13); 

        int [] array = queue.asArray();
        System.out.println(queue.length());

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        
        System.out.println();
        System.out.println(queue.remove() + "//");
        System.out.println(queue.length());
        array = queue.asArray();

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}        

