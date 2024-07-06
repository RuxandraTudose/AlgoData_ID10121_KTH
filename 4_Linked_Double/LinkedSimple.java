class LinkedSimple {
 
	public class Node {
		public int number;
		public Node next;

		public Node (int number) {
			this.number = number;
			this.next = null;
		}
	}

    public Node first = null;

    public void createList (int[] numbers) throws Exception {
		if(this.first != null) {
			throw new Exception("List already initialized");
		}
		this.first = new Node(numbers[0]);
		Node current = this.first;

		for (int i = 1; i < numbers.length; i++) {
			current.next = new Node(numbers[i]);
			current = current.next;
		}
	}
    
    public Node getNode(int index) {       
        int currentIndex = 0;
        Node currentNode = this.first;
		
        while (currentIndex <= index && currentNode != null) {
			if(currentIndex == index)
				return currentNode;
            currentIndex++;
            currentNode = currentNode.next;
        }
        return null;
    }

   	int length () {
		int count = 0;
		Node index = first;
		
        while(index.next != null) {
            count++;
			index = index.next;
	    }

	    return count + 1;
    }
	
    public int[] asArray() {
		int [] array = new int [length()];
		Node index = first;
		for (int i = 0; i < length(); i++) {
			array[i] = index.number;
			index = index.next;
	    }

	    return array;
	}

    void unlink(Node toRemove) {
        Node index = first;

        if(toRemove == null)
            return;

        if(toRemove == first)  {
            first = first.next;
            return;
        }    

        while(index != null) {
            if(index.next == toRemove) {
                index.next = toRemove.next;
            }    
            
            index = index.next;
        }
    }

    void insert(Node toAdd) {
        toAdd.next = first;
        first = toAdd;
    }
}

