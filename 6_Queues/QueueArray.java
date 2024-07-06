public class QueueArray {

    Integer [] queue;
    int first, last;
    int size;
    int eq;

    public QueueArray() {
        size = 4;
        queue = new Integer [size];
        first = 0;
        last = 0;
    }

    public void enqueue (Integer itm) {
       
        queue [last] = itm;
        last = (last + 1) % size;

        if(last == first ) {
            Integer [] copyarray = new Integer [size *2];
            int index = 0;

            for(int i = first; i < size; i++) {
                copyarray[index++] = queue [i];
            }

            for(int i = 0 ; i < last; i++) {
                copyarray[index++] = queue [i];
            }

            queue = copyarray;
            first = 0;
            last = size;//point to free slot last =c 
            size = size * 2;
        }

    }

    public Integer dequeue() {
        
        if(first == last)
            return null;    
 
        Integer ret = queue[first];
        queue[first] = null;
        first = (first + 1) % size;
        return ret;
    }

    public static void main(String[] args) { 

        QueueArray q = new QueueArray();
        q.enqueue(4);
        q.enqueue(13);
     
          System.out.println(q.dequeue() + "?");
        q.enqueue(66);
        System.out.println(q.dequeue() + "?");
        q.enqueue(45);
          //q.enqueue(66);
     //   System.out.println(q.dequeue());
        //q.enqueue(9);

      
      



    }


}


/*public class QueueArray <K> {

    Integer [] queue;
    int first, last;
    int size;

}

public //constructor 

size = 4;
queue = new Integer [size];
first = 0;
last = 0;

//end constructor


boolean empty  first = last

public void enqueeu (Integer a){
    queue [last] = itm;
    last = (last + 1)% size;
    if(last == frist) {
        Integer [] copy = new Integer [size *2];
        int c = 0;
        for(int i = first; i < size; i++) {
            copy[c++] = queue [i];
        }

        for(int i = 0 ; i < last; i++) {
            copy[c++] = queue [i];
        }

        queue = copy;
        first = 0;
        last = size;//point to free slot last =c 
        size = size * 2;
    }

}

public Integer dequeue() {
    
    if(first == last)
        return null;

    Integer ret = queue[first];
    first = (first + 1) % size;
    return ret;
}
//last to an empty slot
//first and last point to the same thing - empty queue*/