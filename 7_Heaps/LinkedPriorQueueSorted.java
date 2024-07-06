public class LinkedPriorQueueSorted {

 Node head;
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }    
    }

    public LinkedPriorQueueSorted() {
         head = null;
    }

    public void add(Integer item) {

        if(head == null) {
            head = new Node (item, null);
            return;
        }

        Node n;

        if (item < head.item) {
            n = new Node(item, null);
            n.next = head;
            head = n;
            return;
        }

        Node index = head;
        while(index.next != null) {
            if(item > index.item && item < index.next.item) {
                n = new Node(item, null);
                n.next = index.next;
                index.next = n;
                return;
            }

            index = index.next;
        }

        n = new Node(item, null);
        index.next = n;
    }

    public Integer remove() {
        
        if(head != null) {
            int c = head.item;
            head = head.next;
            return c;
        }

        else return null;
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
        LinkedPriorQueueSorted q = new LinkedPriorQueueSorted();

        q.add(7);
        q.add(13);
        q.add(9);
        q.add(0);
        q.add(3);
        q.add(90); 
        q.add(12);

        int [] b = q.asArray();
        System.out.println(b.length);
        
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");

        System.out.println();   
        System.out.println("//////");    
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

       
}    