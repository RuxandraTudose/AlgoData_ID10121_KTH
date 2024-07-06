class LinkedList {
 
  private class Node {

		public int number;
		public Node next;

		public Node (int number) { //the constructor - same name as the class!!
		
			this.number = number;
			next = null;
		}
	}

    Node first; //create the reference to the linked list
  

    void add (int item) {
    
        first = new Node(item); //next is null automatically; first is a global variable
	}

//EXTRA
    void createlist (int[] numbers) {
	
        Node n = first; // helps me navigate the list - reference sau pointer cum stiu eu
		for (int i = 1; i < numbers.length; i++) //from 1 because head is already initialised
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}


   	int length () {

		int count = 0;
		Node index = first; //copy of head - a node not linked to the list that helps me navigate the list
		
        while(index.next!= null) {
			
            count++;
			index = index.next; //move the pointer to the next element
	    }

	    return count + 1; // I add the last element where null is!
    }


    boolean find (int value) {

        Node index = first; //take the reference of the linked list - use the pointer to navigate in the list
      
        while(index.next != null) {

            if(index.number == value)
                return true;
            
            index = index.next;     
        }

        if(index.number == value)
            return true;

        return false;
    }

      void remove(int item) { // and last element

        if(find(item) == true) {

            Node previous = first;
            Node current = first.next;
            
            if(previous.number == item) // special cases for first element
                first = first.next;

            while (current.next != null) {

                if(current.number == item) {

                    previous.next = current.next;
                   
                }

                previous = current;
                current = current.next;
            }

            if(current.number == item) {
                previous.next = null;

            }
        }

    } 


    void append(LinkedList list) {

        Node nxt = this.first;

        while (nxt.next != null) {
            nxt = nxt.next;
        }
        
        nxt.next = list.first;
    }

    int[] asArray() {

		int [] array = new int [length()];
		Node index = first;
		for (int i = 0; i < length(); i++) {
			array[i] = index.number;
			index = index.next;
	    }

	    return array;
	}

    void push (int a) {

        Node index = first;
        Node new_element = new Node(a);

        while(index.next != null) {

            index = index.next;
        }

        index.next = new_element;
    }

    int pop(LinkedList stack) {

        
        if(stack.length() > 0) {

            Node previous = first;
            Node current = first.next;

            while (current.next != null) {

                previous = current;
                current = current.next;
            }
            
            int c = current.number;
            previous.next = null;

            return c;

        }

        else return -1;

    }

     public static void main(String[] args) {

      //  int [] numbers = {12, 5, 8 ,10, 22, 13, 7};
       int [] numbers_2 = {11, 5, 3 ,90, 22, 13, 25};
       float avg = 0;

     //  int [] sizes = {10}; //50, 100, 150, 250, 300, 500};
        int [] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
        LinkedList linked_2 = new LinkedList();
        linked_2.add(numbers_2[0]);
        linked_2.createlist(numbers_2);

        LinkedList linked_3 = new LinkedList();
        linked_3.add(numbers_2[0]);
        linked_3.createlist(numbers_2);

        System.out.printf("# append list b to list a which has different sizes\n");
        System.out.printf("#%s %2s %2s\n", "n","time", "size");

        for (int n : sizes) {
             
            LinkedList linked = new LinkedList();
            LinkedList linked_b = new LinkedList();
            int [] numbers = generate_array.array(n);

            linked.add(numbers[0]);
            linked.createlist(numbers);

            linked_b.add(numbers[0]);
            linked_b.createlist(numbers);

          //  int [] a = linked.asArray();   

//vary size first array - append list b - fixed size
            long t0 = System.nanoTime();
            linked.append(linked_2); 
            long t1 = System.nanoTime();
            double t_append_varyA = (t1 - t0); 

            linked_3.add(numbers_2[0]); //reset fixed linked list!!! 
            linked_3.createlist(numbers_2);


//vary size second array - append list a - fixed size
            long t2 = System.nanoTime();
            linked_3.append(linked_b); 
            long t3 = System.nanoTime();
            double t_append_varyB = (t3 - t2); 

//APPEND TWO ARRAYS
            
            int [] a = generate_array.array(n);
            int [] b = {1,3,4,83,14,15,16};

            long t4 = System.nanoTime();
            int [] c = AppendArray.append(a,b);
            long t5 = System.nanoTime();
            double t_append_array = (t5 - t4); 

            avg += t_append_array/t_append_varyA;

           System.out.printf("%d %4.0f %4.0f %4.0f %4.2f\n", n, t_append_varyA, t_append_varyB, t_append_array, t_append_array/t_append_varyA);
          
        }

        System.out.printf("%4.2f", avg/12); //average ratio
        System.out.println();


//STACK : my pop doensn't work if stack is empty :(
            LinkedList stack = new LinkedList();
            stack.add(13);
            stack.push(5);
            stack.push(8);
            stack.push(9);
            stack.push(10);
           int [] s = stack.asArray();

           for(int i = 0; i < s.length; i++)
                System.out.print(s[i] +  " ");

            System.out.println();
            System.out.println();

            System.out.println(stack.pop(stack));  
            System.out.println (stack.pop(stack));         
    }




}

