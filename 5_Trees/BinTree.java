public class BinTree {

    public class Node {

        public Integer key;
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer key, Integer value) { //constructor fpor Node
            this.key = key;
            this.value = value;
            this.left = this.right = null; //initialize with null 
        }

        private void add (Integer key , Integer value) { //this refers to the current object - adica root cand ii dau call prima oara 
           
            if (this.key == key) {
                this.value = value ;
                return;
            }
            if (this.key > key) {
                if(this.left == null)
                    this.left = new Node(key, value);
                else
                    this.left.add(key, value);  //trimit cheia de la ce e la left   
            }
            else {
                if(this.right == null)
                    this.right = new Node(key, value);
                else
                    this.right.add(key,value);    
            }
        }    

        public Integer lookup(Integer key) {
            
            if(this.key == key) {
                return this.value;
            }
            else {
                if(this.key > key)
                    if(this.left != null)
                        return this.left.lookup(key);
                if(this.key < key)
                    if(this.right != null)
                        return this.right.lookup(key);    
            }

            return null;
        }

        public void print() {
           
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                 right.print();
            }
    }

    Node root;

    public BinTree() { //object constructor

        root = null;
    }

    public void add (Integer key, Integer value) {
        if(root == null) {
            root = new Node(key, value);
        }
        else {
            root.add(key,value); //prin asta trimit initial cheia radacinii - aici e cheia ca sa incep parcurgerea in copacel
        }
    }

    public Integer lookup (Integer key) {
    
        return root.lookup(key);
    }

    public void print() {
       // System.out.println("kkkey" + root.key);
        root.print(); 
    }
}