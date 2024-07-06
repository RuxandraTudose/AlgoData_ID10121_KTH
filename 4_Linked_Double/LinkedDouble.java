class LinkedDouble {
 
  public class Node {
		public int number;
		public Node next;
        public Node prev;

		public Node (int number) {
			this.number = number;
			next = null;
            prev = null;
		}
	}

    Node first;

    void createList(int[] numbers) throws Exception {
		if(this.first != null) {
			throw new Exception("List already initialized");
		}
        this.first = new Node(numbers[0]);
		Node current = this.first;
		
		for (int i = 1; i < numbers.length; i++) {
			current.next = new Node(numbers[i]);
			current.next.prev = current;
			current = current.next;
		}
	}


    public Node getNode(int index) {
        int count = 0;
        Node currentnode = first;

        while(count < index && currentnode != null) {
            count ++;
            currentnode = currentnode.next;
        }

        return currentnode;
    }

   	int length() {
		int count = 0;
		Node index = first;
		
        while(index.next != null) {
            count++;
			index = index.next;
	    }

	    return count + 1;
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


    void unlink(Node toRemove) {
        if(toRemove == null)
           return;

        if(toRemove.prev == null) {
            first = toRemove.next;
            toRemove.next.prev = null;
            return;
        }
		
        if(toRemove.next == null) {
            toRemove.prev.next = null;
            return;
        }

        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }    

    void insert(Node toAdd) {
        toAdd.next = first;
        toAdd.prev = null;
        first.prev = toAdd;
        first = toAdd;
    }
}    


